package com.chaqui.sysres.controller;

import com.chaqui.sysres.dto.TipoDto;
import com.chaqui.sysres.service.TipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name =  "Tipo")
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
    @Operation(summary = "Consulta los tipos por descriminador")
    public List<TipoDto.Response> obtenerPorDescriminador(
            @Parameter(name = "descriminador" , description = "Descriminador de tipos a consultar")
            @RequestParam(required = true)
            @NotNull(message = "Debe especificar el tipo de producto") String descriminador) {
        return tipoService.getTipos(descriminador);
    }
}
