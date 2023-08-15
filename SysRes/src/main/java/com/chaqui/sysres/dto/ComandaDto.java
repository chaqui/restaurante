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
}
