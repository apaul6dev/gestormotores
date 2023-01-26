package com.grapes.mmotor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdenTrabajo;
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "fregistro", nullable = false)
    private LocalDateTime fRegistro;
    @OneToOne
    @JoinColumn(name = "id_mantenimiento")
    private Mantenimiento mantenimiento;

}
