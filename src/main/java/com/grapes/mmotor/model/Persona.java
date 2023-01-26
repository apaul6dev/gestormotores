package com.grapes.mmotor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    @Column(name = "pnombre", nullable = false, precision = 50)
    private String pnombre;
    @Column(name = "snombre", precision = 50)
    private String snombre;
    @Column(name = "papellido", nullable = false, precision = 50)
    private String papellido;
    @Column(name = "sapellido", precision = 50)
    private String sapellido;
    @Column(name = "numDni", nullable = false, precision = 50)
    private String numDni;
    @Column(name = "correo_electronico", precision = 50)
    private String correoElectronico;
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "fregistro", nullable = false)
    private LocalDateTime fRegistro;

}
