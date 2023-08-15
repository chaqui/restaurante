package com.chaqui.sysres.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cuenta")
@NoArgsConstructor
public class Cuenta {

    @Id
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_comanda")
    private Comanda comanda;

    @Column(name = "total")
    private BigDecimal total;

    public Cuenta(Comanda comanda) {
        this.comanda = comanda;
    }
}
