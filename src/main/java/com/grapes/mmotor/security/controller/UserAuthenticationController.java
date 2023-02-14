package com.grapes.mmotor.security.controller;

import com.grapes.mmotor.security.dto.UserAuthenticationRequestDTO;
import com.grapes.mmotor.security.dto.UserAuthenticationResponseDTO;
import com.grapes.mmotor.security.dto.UserRegisterRequestDTO;
import com.grapes.mmotor.security.service.impl.UserAuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final UserAuthenticationServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<UserAuthenticationResponseDTO> register(@RequestBody UserRegisterRequestDTO request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserAuthenticationResponseDTO> authenticate(@RequestBody UserAuthenticationRequestDTO request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}