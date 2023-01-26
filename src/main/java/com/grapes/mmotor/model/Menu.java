package com.grapes.mmotor.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;
    @Column(name = "icono", length = 20)
    private String icono;
    @Column(name = "nombre", length = 20)
    private String nombre;
    @Column(name = "url", length = 50)
    private String url;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> roles;
}
