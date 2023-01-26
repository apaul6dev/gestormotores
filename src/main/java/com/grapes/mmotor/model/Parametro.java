package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parametro")
public class Parametro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParametro;

    @Column(name = "nombre", precision = 25, nullable = false)
    private String nombre;

    @Column(name = "unidad", precision = 25, nullable = false)
    private String unidad;

    @Column(name = "descripcion", precision = 150)
    private String descripcion;

}
