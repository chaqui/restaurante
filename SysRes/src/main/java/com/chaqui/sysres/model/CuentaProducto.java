package com.chaqui.sysres.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta_producto")
public class CuentaProducto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;
}
