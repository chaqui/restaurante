package com.chaqui.sysres.dto;

import lombok.Data;

/**
 * Clase que representa el objeto Tipo
 */
public class TipoDto {

    /**
     * Clase que representa la respuesta de la consulta de tipos
     */
    @Data
    public static class Response{

        private Integer id;
        private String nombre;
        private String descriminador;
        private String anotacion;
    }
}
