package com.chaqui.sysres.controller;

import com.chaqui.sysres.dto.TipoDto;
import com.chaqui.sysres.service.TipoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Tipo")
@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    /**
     * Obtiene los tipos por descriminador
     *
     * @param descriminador descriminador a buscar
     * @return lista de tipos
     */
    @ResponseBody
    @GetMapping
    @ApiOperation(value = "Consulta los tipos por descriminador")
    public List<TipoDto.Response> obtenerPorDescriminador(
            @ApiParam(value = "Descriminador de tipos a consultar")
            @RequestParam(required = true)
            @NotNull(message = "Debe especificar el tipo de producto") String descriminador) {
        return tipoService.getTipos(descriminador);
    }
}
