package com.chaqui.sysres.repository;

import com.chaqui.sysres.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repositorio de tipos
 */
public interface TipoRepository extends JpaRepository<Tipo, Integer> {

    /**
     * Busca los tipos por descriminador en la base de datos
     * @param descriminador descriminador a buscar
     * @return lista de tipos
     */
    List<Tipo> findByDescriminador(String descriminador);
}
