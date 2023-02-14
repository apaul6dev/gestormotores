package com.grapes.mmotor.security.model;

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
@Table(name = "_role")
public class Role {
    @Id
    @Column(name = "role", nullable = false, precision = 50)
    private String role;
    @Column(name = "description", nullable = false, precision = 50)
    private String description;

}
