package com.example.demo;

import com.example.demo.dao.categoria.CategoriaDAO;
import com.example.demo.dao.marca.MarcaDAO;
import com.example.demo.dao.precio.precioRep;
import com.example.demo.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication  {


	public static void main(String[] args) {
		ConfigurableApplicationContext contex = SpringApplication.run(DemoApplication.class, args);
		fillTables(contex);
	}
	private static void fillTables(ConfigurableApplicationContext context){
		MarcaDAO repMarca = context.getBean(MarcaDAO.class);
		CategoriaDAO catg = context.getBean(CategoriaDAO.class);
		precioRep repository = context.getBean(precioRep.class);



		repMarca.save(new Marca("pronasoya"));
		repMarca.save(new Marca("nutrisa"));
		repMarca.save(new Marca("pronat"));
		repMarca.save(new Marca("supermayoreo"));

		catg.save(new Categoria("bienestar"));
		catg.save(new Categoria("salud"));
		catg.save(new Categoria("belleza"));
		catg.save(new Categoria("intimitad"));
		catg.save(new Categoria("deporte"));






	}

}
