package com.smart.ware.login.dto;

import com.smart.ware.token.dto.TokenManager;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class LoginResponse {

    private TokenManager tokens;
    private String userId;

}
