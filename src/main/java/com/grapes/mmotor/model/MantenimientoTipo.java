package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mantenimiento_tipo")
public class MantenimientoTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMantenimientoTipo;

    @Column(name = "nombre", precision = 25)
    private String nombre;

    @Column(name = "descripcion", precision = 150)
    private String descripcion;
}
