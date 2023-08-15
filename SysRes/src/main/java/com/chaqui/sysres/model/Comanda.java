package com.chaqui.sysres.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "comanda")
@NoArgsConstructor
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

    public Comanda(Tipo mesa, Tipo estado) {
        this.mesa = mesa;
        this.estado = estado;
    }
}
