package com.chaqui.sysres.dto;

import lombok.Data;

import java.math.BigDecimal;

public class ProductoDto {

    /**
     * Clase que representa los datos de ingreso de un producto
     */
    @Data
    public static class Request{
        private Integer idTipo;
        private String nombre;
        private String comentario;
        private BigDecimal precio;
    }

    /**
     * Clase que representa la respuesta de la consulta de productos
     */
    @Data
    public static class Response{
        private Integer id;
        private String nombre;
        private String comentario;
        private BigDecimal precio;
    }
}
