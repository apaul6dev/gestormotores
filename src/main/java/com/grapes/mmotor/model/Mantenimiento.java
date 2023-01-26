package com.grapes.mmotor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMantenimiento;
    @Column(name = "observaciones", precision = 300, nullable = false)
    private String observaciones;
    @ManyToOne
    @JoinColumn(name = "id_generador", nullable = false)
    private Generador generador;
    @ManyToOne
    @JoinColumn(name = "id_mantenimiento_tipo", nullable = false)
    private MantenimientoTipo mantenimientoTipo;
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "fregistro", nullable = false)
    private LocalDateTime fRegistro;
    @OneToMany(mappedBy = "mantenimiento", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MantenimientoDetalle> matenimientoDetalle;

    @OneToOne(mappedBy = "mantenimiento")
    private OrdenTrabajo ordenTrabajo;
}
