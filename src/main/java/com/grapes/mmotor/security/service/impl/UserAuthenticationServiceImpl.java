package com.grapes.mmotor.security.service.impl;

import com.grapes.mmotor.security.dto.UserRegisterRequestDTO;
import com.grapes.mmotor.security.config.JwtService;
import com.grapes.mmotor.security.dto.UserAuthenticationRequestDTO;
import com.grapes.mmotor.security.dto.UserAuthenticationResponseDTO;
import com.grapes.mmotor.security.emuns.UserType;
import com.grapes.mmotor.security.model.User;
import com.grapes.mmotor.security.dao.UserDao;
import com.grapes.mmotor.security.service.IUserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements IUserAuthenticationService {
    private final UserDao repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleServiceImpl roleService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserAuthenticationResponseDTO register(UserRegisterRequestDTO request) {
        var user = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .enabled(true)
                .fdesde(LocalDateTime.now())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType(UserType.INTERNO)
                .role(roleService.getRole(request.getRole())).build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return UserAuthenticationResponseDTO.builder().token(jwtToken).build();
    }

    @Override
    public UserAuthenticationResponseDTO authenticate(UserAuthenticationRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = repository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return UserAuthenticationResponseDTO.builder().token(jwtToken).build();
    }
}
