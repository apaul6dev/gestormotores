package com.grapes.mmotor.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "rol_categoria")
public class RolCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRolCategoria;
    @Column(name = "nombre", precision = 25)
    private String nombre;
    @Column(name = "descripcion", precision = 150)
    private String descripcion;
}
