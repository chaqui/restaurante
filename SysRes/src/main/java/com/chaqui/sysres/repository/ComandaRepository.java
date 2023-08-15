package com.chaqui.sysres.repository;

import com.chaqui.sysres.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    /**
     * Busca las comandas por mesa en la base de datos
     * @param idMesa id de la mesa a buscar
     * @return lista de comandas
     */
    @Query("SELECT c FROM Comanda c WHERE c.mesa.id = :idMesa")
    public List<Comanda> findByMesa(Integer idMesa);
}
