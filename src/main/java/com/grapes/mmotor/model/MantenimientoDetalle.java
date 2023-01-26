package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mantenimiento_detalle")
public class MantenimientoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMantenimientoDetalle;
    @ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
    private Material material;
    @ManyToOne
    @JoinColumn(name = "id_mantenimiento", nullable = false)
    private Mantenimiento mantenimiento;
}
