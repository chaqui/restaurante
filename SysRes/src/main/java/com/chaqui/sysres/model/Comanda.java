package com.chaqui.sysres.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comanda")
public class Comanda {
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private Tipo mesa;

    @Column(name = "total")
    private Number total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private Tipo estado;
}
