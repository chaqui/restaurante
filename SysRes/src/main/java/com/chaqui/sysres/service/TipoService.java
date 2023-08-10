package com.chaqui.sysres.service;


import com.chaqui.sysres.dto.TipoDto;
import com.chaqui.sysres.model.Tipo;
import com.chaqui.sysres.repository.TipoRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Obtiene los tipos por descriminador
     *
     * @param descriminador descriminador a buscar
     * @return lista de tipos
     */
    public List<TipoDto> getTipos(String descriminador) {
        List<Tipo> tipos = tipoRepository.findByDescriminador(descriminador);
        if (CollectionUtils.isEmpty(tipos)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No se encontraron tipos"
            );
        }
        List<TipoDto> dtos = tipos.stream().map(tipo -> {
            return modelMapper.map(tipo, TipoDto.class);
        }).toList();

        return dtos;
    }
}
