package com.chaqui.sysres.dto;

import lombok.Data;

public class CuentaProductoDto {

    @Data
    public static class Request{
        private Integer idProducto;
        private Integer idCuenta;
        private String comentario;
    }
}
