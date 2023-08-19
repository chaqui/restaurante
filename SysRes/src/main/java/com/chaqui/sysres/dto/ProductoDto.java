package com.chaqui.sysres.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductoDto {

    /**
     * Clase que representa los datos de ingreso de un producto
     */
    @Data
    @Schema(description = "Objeto con la información de solicitud del producto")
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
    @Schema(description = "Objeto con la información de respuesta del producto")
    public static class Response{
        private Integer id;
        private String nombre;
        private String comentario;
        private BigDecimal precio;
    }
}
