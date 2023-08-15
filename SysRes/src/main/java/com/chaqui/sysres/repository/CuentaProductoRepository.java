package com.chaqui.sysres.repository;

import com.chaqui.sysres.model.CuentaProducto;
import com.chaqui.sysres.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaProductoRepository extends JpaRepository<CuentaProducto, Integer> {

    /**
     * Busca los productos por cuenta en la base de datos
     * @param idCuenta id de la cuenta a buscar
     * @return lista de productos
     */
    @Query("SELECT c.producto FROM CuentaProducto c WHERE c.cuenta.id = :idCuenta")
    public List<Producto> findByCuenta(Integer idCuenta);
}
