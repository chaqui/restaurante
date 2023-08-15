package com.chaqui.sysres.repository;

import com.chaqui.sysres.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    /**
     * Busca las cuentas por comanda en la base de datos
     * @param idComanda id de la comanda a buscar
     * @return lista de cuentas
     */
    @Query("SELECT c FROM Cuenta c WHERE c.comanda.id = :idComanda")
    public List<Cuenta> findByComanda(Integer idComanda);
}
