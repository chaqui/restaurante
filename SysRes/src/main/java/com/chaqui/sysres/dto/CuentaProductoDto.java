package com.chaqui.sysres.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CuentaProductoDto {

    @Data
    @Schema(description = "Objeto con la información de solicitud de la Cuenta")
    public static class Request{
        private Integer idProducto;
        private Integer idCuenta;
        private String comentario;
    }
}
