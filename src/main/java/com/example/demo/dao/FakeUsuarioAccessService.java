package com.example.demo.dao;

import com.example.demo.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.UUID;

@Repository("fakeRep")
public class FakeUsuarioAccessService implements  UsuarioDAO{

    private  static List<Usuario> DB = new ArrayList<>();
    @Override
    public int insertUsuario(UUID id, Usuario usuario) {
        DB.add(new Usuario(id, usuario.getNombre()));
        return 0;
    }

    @Override
    public List<Usuario> selectAllUsuarios() {
        return DB;
    }

    @Override
    public Optional<Usuario> selectUsuarioID(UUID id) {
        return DB.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUsuario(UUID id) {
        Optional<Usuario> usuarioMaybe =  selectUsuarioID(id);
        if(usuarioMaybe.isEmpty()){
            return 0;
        }
        DB.remove(usuarioMaybe.get());
        return 1;
    }

    @Override
    public int updateUsuario(UUID id, Usuario usuario) {
        return selectUsuarioID(id)
                .map(x -> {
                    int indexOfUser = DB.indexOf(x);
                    if(indexOfUser >=0){
                        DB.set(indexOfUser, new Usuario(id, usuario.getNombre()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
