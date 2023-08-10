package com.chaqui.sysres;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SysResApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysResApplication.class, args);
    }

    /**
     * ModelMapper es una libreria que permite mapear objetos de una clase a otra de forma automatica.
     *
     * @return Bean de  ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
