package com.chaqui.sysres.repository;

import com.chaqui.sysres.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer> {

    /**
     * Busca las comandas por mesa y estado en la base de datos
     * @param idMesa id de la mesa a buscar
     * @param idEstado id del estado a buscar
     * @return lista de comandas
     */
    @Query("SELECT c FROM Comanda c WHERE c.mesa.id = :idMesa AND c.estado.id = :idEstado")
    public Optional<Comanda> findByMesaAAndEstado(Integer idMesa, Integer idEstado);
}
