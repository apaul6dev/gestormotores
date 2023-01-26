package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name = "nombre", precision = 25, nullable = false)
    private String nombre;
    @Column(name = "descripcion", precision = 150)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_rol_categoria", nullable = false)
    private RolCategoria rolCategoria;
}
