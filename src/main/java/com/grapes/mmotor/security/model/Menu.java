package com.grapes.mmotor.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_menu")
public class Menu {
    @Id
    private Integer idMenu;
    @Column(name = "icon", length = 20)
    private String icon;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "url", length = 50)
    private String url;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "_menu_role", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "role"))
    private List<Role> roles;

}
