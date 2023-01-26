package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parametro_mantenimiento")
public class ParametroMantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParametroMantenimiento;
    @Column(name = "valor", nullable = false)
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "id_parametro", nullable = false)
    private Parametro parametro;
    @ManyToOne
    @JoinColumn(name = "id_mantenimiento", nullable = false)
    private Mantenimiento mantenimiento;
}
