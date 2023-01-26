package com.grapes.mmotor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "material_categoria")
public class MaterialCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaterialCategoria;
    @Column(name = "nombre", precision = 25)
    private String nombre;
    @Column(name = "descripcion", precision = 150)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_material_categoria_padre")
    private MaterialCategoria materialCategoriaPadre;
}
