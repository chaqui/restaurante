package com.chaqui.sysres.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access =AccessLevel.PRIVATE)
public class ComandaDto {

    @Data
    @Schema(description = "Objeto con la información de solicitud de la Comanda")
    public static class Request{
        private Integer idMesa;
    }

    @Data
    @Schema(description = "Objeto con la información de respuesta de la Comanda")
    public static class Response{
        private Integer id;
        private Integer idMesa;
        private String estado;
    }
}
