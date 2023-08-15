package com.chaqui.sysres.model;

import com.chaqui.sysres.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "producto")
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "comentario")
    private String comentario;

    @Column(name = "total")
    private BigDecimal precio;
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    public Producto(ProductoDto.Request dtoProducto, Tipo tipo){
        this.nombre = dtoProducto.getNombre();
        this.comentario = dtoProducto.getComentario();
        this.precio = dtoProducto.getPrecio();
        this.tipo = tipo;
    }


}
