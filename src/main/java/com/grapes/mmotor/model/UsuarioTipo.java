package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_tipo")
public class UsuarioTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;
    @Column(name = "nombre", precision = 25, nullable = false)
    private String nombre;
    @Column(name = "descripcion", precision = 150)
    private String descripcion;

}
