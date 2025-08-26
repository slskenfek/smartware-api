package com.smart.ware.domain.login.service;

import com.smart.ware.domain.login.dto.LoginRequest;
import com.smart.ware.domain.login.dto.LoginResponse;
import com.smart.ware.domain.token.dto.TokenManager;
import com.smart.ware.domain.token.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest loginRequest) throws NoSuchAlgorithmException {
        String accessToken = "";
        String refreshToken = "";
        Authentication auth = null;
        try {
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.userId(), loginRequest.password())
            );
            accessToken = tokenService.createAccessToken(auth);

            refreshToken = tokenService.createRefreshToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        var tokenManager = new TokenManager(
                accessToken,
                refreshToken,
                LocalDateTime.now().plusMinutes(30)
        );

        return new LoginResponse(tokenManager, auth.getName());
    }


}
