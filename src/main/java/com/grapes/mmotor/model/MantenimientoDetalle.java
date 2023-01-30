package com.grapes.mmotor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mantenimiento_detalle")
public class MantenimientoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMantenimientoDetalle;
    @Column(name = "observaciones", precision = 300, nullable = false)
    private String observaciones;
    @Column(name = "revision", nullable = true)
    private boolean revision;
    @Column(name = "cambio", nullable = true)
    private boolean cambio;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_mantenimiento", nullable = false)
    private Mantenimiento mantenimiento;
}
