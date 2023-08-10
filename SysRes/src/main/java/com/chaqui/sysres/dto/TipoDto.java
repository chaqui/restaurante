package com.chaqui.sysres.dto;

import lombok.Data;

public class TipoDto {

    @Data
    public static class Response{
        private String nombre;
        private String descriminador;
        private String anotacion;
    }
}
