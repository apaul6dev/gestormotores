package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    @Column(name = "nombre", precision = 100)
    private String nombre;

    @Column(name = "descripcion", precision = 150)
    private String descripcion;

}
