package com.grapes.mmotor.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name = "nombre", nullable = false, unique = true, precision = 25)
    private String username;
    @Column(name = "clave", nullable = false)
    private String password;
    @Column(name = "estado", nullable = false)
    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
    private List<Rol> roles;
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "fregistro", nullable = false)
    private LocalDateTime fRegistro;
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "id_usuario_tipo", nullable = false)
    private UsuarioTipo usuarioTipo;
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_mantenimiento", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_mantenimiento", referencedColumnName = "idMantenimiento"))
    private List<Mantenimiento> mantenimientos;

}
