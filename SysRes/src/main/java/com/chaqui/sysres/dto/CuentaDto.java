package com.chaqui.sysres.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CuentaDto {

    @Data
    public static class Request{
        private Integer idComanda;
    }

    @Data
    public static class Response{
        private Integer id;
        private Integer idComanda;
        private BigDecimal total;
    }
}
