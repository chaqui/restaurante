package com.chaqui.sysres.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access =AccessLevel.PRIVATE)
public class ComandaDto {

    @Data
    public static class Request{
        private Integer idMesa;
    }

    @Data
    public static class Response{
        private Integer id;
        private Integer idMesa;
        private String estado;
    }
}
