package com.chaqui.sysres.repository;

import com.chaqui.sysres.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    /**
     * Busca los productos por tipo en la base de datos
     * @param idTipo id del tipo a buscar
     * @return lista de productos
     */
    @Query("SELECT p FROM Producto p WHERE p.tipo.id = :idTipo")
    public List<Producto> findByTipo(Integer idTipo);
}
