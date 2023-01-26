package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "generador")
public class Generador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenerador;
    @Column(name = "marca", precision = 150)
    private String marca;
    @Column(name = "codigo", precision = 150)
    private String codigo;
    @Column(name = "potencia")
    private Double potencia;
    @Column(name = "num_horas")
    private Integer  numHoras;
    @Column(name = "num_cilindros")
    private Integer  numCilindros;
}
