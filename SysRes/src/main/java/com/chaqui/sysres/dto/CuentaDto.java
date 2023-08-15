package com.chaqui.sysres.dto;

import lombok.Data;

import java.math.BigDecimal;

public class CuentaDto {

    @Data
    public static class Request{
        private Integer idComanda;
    }

    public static class Response{
        private Integer id;
        private Integer idComanda;
        private BigDecimal total;
    }
}
