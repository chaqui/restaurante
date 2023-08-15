package com.chaqui.sysres.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa el objeto Tipo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TipoDto {

    /**
     * Clase que representa la respuesta de la consulta de tipos
     */
    @Data
    public static class Response{

        private Integer id;
        private String nombre;
        private String anotacion;
    }
}
