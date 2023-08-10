package com.chaqui.sysres.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Tipo", schema = "SR")
public class Tipo {
    @Id
    @Column(name = "id_tipo")
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descriminador")
    private String descriminador;

    @Column(name = "Anotacion")
    private String anotacion;
}
