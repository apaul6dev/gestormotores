package com.grapes.mmotor.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDTO {
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String role;

}
