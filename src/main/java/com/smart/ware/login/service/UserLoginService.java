package com.smart.ware.login.service;

import com.smart.ware.login.dto.LoginRequest;
import com.smart.ware.login.dto.LoginResponse;
import com.smart.ware.token.dto.TokenManager;
import com.smart.ware.token.service.TokenService;
import com.smart.ware.users.dto.UserResponse;
import com.smart.ware.users.service.UserAuthService;
import com.smart.ware.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest loginRequest) {

        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.userId(), loginRequest.password())
        );
        tokenService.createAccessToken(auth);
        return null;
    }


}
