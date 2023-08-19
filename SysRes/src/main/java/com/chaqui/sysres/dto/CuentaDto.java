package com.chaqui.sysres.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CuentaDto {

    @Data
    @Schema(description = "Objeto con la información de solicitud de la Cuenta")
    public static class Request{
        private Integer idComanda;
    }

    @Data
    @Schema(description = "Objeto con la información de respuesta de la Cuenta")
    public static class Response{
        private Integer id;
        private Integer idComanda;
        private BigDecimal total;
    }
}
