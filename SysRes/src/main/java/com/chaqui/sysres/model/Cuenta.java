package com.chaqui.sysres.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_comanda")
    private Comanda comanda;

    @Column(name = "total")
    private Number total;
}
