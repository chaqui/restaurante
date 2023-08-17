package com.chaqui.sysres.controller;

import com.chaqui.sysres.dto.ComandaDto;
import com.chaqui.sysres.service.ComandaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "producto")
@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;


    @PostMapping
    @ApiOperation(value = "Crea un producto", notes = "Crea una comanda en el sistema")
    @ResponseStatus(code = HttpStatus.OK, reason = "Comanda creada")
    public void crearComanda(ComandaDto.Request request){
        this.comandaService.crearComanda(request);
    }
}
