package com.example.demo.dao;

import com.example.demo.model.Categoria;
import com.example.demo.model.Marca;
import com.example.demo.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("producto")
public class ProductoDataAccessService implements ProductoDAO{

    private final String attrs = "id,  nombre, cantidad, n_marca, imagen, descripcion";
    private final JdbcTemplate jdbctemplate;

    @Autowired
    public ProductoDataAccessService(JdbcTemplate jdbctemplate){
        this.jdbctemplate=jdbctemplate;
    }

    @Override
    public int insert(Producto obj) {
       final UUID id = UUID.randomUUID();

        final int responseProduct =  jdbctemplate.update("INSERT INTO producto ("+attrs+") VALUES (?,?,?,?,?,?)",
                id, obj.getNombre(), obj.getCantidad(), obj.getMarca().getNombre(),
                obj.getImage(), obj.getDescripcion()
        );
        if(responseProduct==1){
            int resp=-1;
            for(Categoria categoria : obj.getCategorias()){
                resp = jdbctemplate.update("INSERT INTO productoCategoria (prodctoID, categoriaID) VALUES (?,?)",
                        id, categoria.getNombre());
                if(resp==0){
                    break;
                }
            }
            if(resp==0){
                this.deleteID(id);
                return 0;
            }
            for(int i = 0; i < obj.getPrecio().length ; i++){
                resp = jdbctemplate.update("INSERT INTO productoprecio (productoID, precioID, precio) VALUES (?,?,?)",
                        id, i, obj.getPrecio()[i]);
                if(resp==0){
                    this.deleteID(id);
                    break;
                }
            }
            return resp;
        }
        return 0;
    }

    @Override
    public List<Producto> selectAll() {

        return jdbctemplate.query("SELECT "+attrs+", fecha FROM producto", (rs, i)->{
            final UUID id = UUID.fromString(rs.getString("id"));
            final float[] listPrecios = getPrecios(id);
            if(listPrecios.length>3 || listPrecios.length<1){
                return null;
            }
            final List<Categoria> listaCategorias =  getCategorias(id);
            return new Producto(
                    id,
                    rs.getString("nombre"),
                    rs.getInt("cantidad"),
                    listPrecios,
                    rs.getString("descripcion"),
                    rs.getString("imagen"),
                    rs.getString("fecha"),
                    new Marca(rs.getString("n_marca")),
                    listaCategorias
            );

        });
    }

    private float[] getPrecios(UUID id){
        Float[] precio = jdbctemplate.query("SELECT precio FROM productoprecio WHERE productoid = '"+id+"'", (resSet ,i)->{
            return resSet.getFloat("precio");
        }).stream().toArray(Float[]::new);
        float[] preciosProd = {precio[0].floatValue(), precio[1].floatValue(), precio[2].floatValue()};
        return preciosProd;
    }

    private List<Categoria> getCategorias(UUID id){
        return jdbctemplate.query("SELECT categoriaid FROM productocategoria WHERE prodctoid ='"+id+"'",
                (resSet,i)->{
                    return new Categoria(resSet.getString("categoriaid"));
                });
    }
    @Override
    public Optional<Producto> selectID(UUID id) {

        float[] preciosProd = getPrecios(id);

        if(preciosProd.length>3 || preciosProd.length<1){
            return Optional.ofNullable(null);
        }
        List<Categoria> categorias = getCategorias(id);

        if(categorias.size()<1){
            return Optional.ofNullable(null);
        }
        Producto producto = jdbctemplate.query("SELECT "+attrs+",fecha FROM producto WHERE id='"+id+"'",
                resSet->{
                    resSet.next();
                    return new Producto(
                            id,
                            resSet.getString("nombre"),
                            resSet.getInt("cantidad"),
                            preciosProd,
                            resSet.getString("descripcion"),
                            resSet.getString("imagen"),
                            resSet.getString("fecha"),
                            new Marca(resSet.getString("n_marca")),
                            categorias
                            );
                });
        return Optional.ofNullable(producto);

    }

    @Override
    public int deleteID(UUID id) {
        return jdbctemplate.update("DELETE FROM producto WHERE id=?", id);

    }

    @Override
    public int updateID(UUID id, Producto obj) {
        return 0;
    }
}
