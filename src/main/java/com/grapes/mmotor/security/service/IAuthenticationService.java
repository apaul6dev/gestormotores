package com.grapes.mmotor.security.service;

import com.grapes.mmotor.security.dto.RegisterRequest;
import com.grapes.mmotor.security.dto.AuthenticationRequest;
import com.grapes.mmotor.security.dto.AuthenticationResponse;

public interface IAuthenticationService {
    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
