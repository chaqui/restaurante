package com.chaqui.sysres.controller;

import com.chaqui.sysres.dto.ComandaDto;
import com.chaqui.sysres.service.ComandaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Comanda")
@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;


    @PostMapping
    @Operation(summary = "Crea un producto")
    @ResponseStatus(code = HttpStatus.OK, reason = "Comanda creada")
    public void crearComanda(ComandaDto.Request request){
        this.comandaService.crearComanda(request);
    }
}
