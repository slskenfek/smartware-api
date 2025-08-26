package com.smart.ware.domain.login.dto;

import com.smart.ware.domain.token.dto.TokenManager;


public record LoginResponse(
        TokenManager tokens,
        String userId
) {


}
