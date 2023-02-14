package com.grapes.mmotor.security.service;

import com.grapes.mmotor.security.dto.UserRegisterRequestDTO;
import com.grapes.mmotor.security.dto.UserAuthenticationRequestDTO;
import com.grapes.mmotor.security.dto.UserAuthenticationResponseDTO;

public interface IUserAuthenticationService {
    public UserAuthenticationResponseDTO register(UserRegisterRequestDTO request);
    public UserAuthenticationResponseDTO authenticate(UserAuthenticationRequestDTO request);
}
