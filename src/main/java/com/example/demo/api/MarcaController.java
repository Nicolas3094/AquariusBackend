package com.example.demo.api;

import com.example.demo.model.Marca;
import com.example.demo.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/marcas")
@RestController
public class MarcaController extends AbsController<Marca, String> {

    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService userService) {
        super(userService);
        this.marcaService = userService;
    }


}
