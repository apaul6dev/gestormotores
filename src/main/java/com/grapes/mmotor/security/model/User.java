package com.grapes.mmotor.security.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.grapes.mmotor.security.emuns.UserType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(name = "username", nullable = false, precision = 50)
    private String username;
    @Column(name = "firstname", nullable = false, precision = 50)
    private String firstname;
    @Column(name = "lastname", nullable = false, precision = 50)
    private String lastname;
    @Column(name = "email", nullable = false, precision = 50)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @JsonSerialize(using = ToStringSerializer.class)
    @Column(name = "fdesde", nullable = false)
    private LocalDateTime fdesde;
    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRole()));
    }

    @Override
    public String getPassword() { return this.password; }
    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
