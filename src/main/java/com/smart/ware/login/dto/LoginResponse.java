package com.smart.ware.login.dto;

import com.smart.ware.token.dto.TokenManager;
import lombok.AllArgsConstructor;
import lombok.Getter;


public record LoginResponse(
        TokenManager tokens,
        String userId
) {


}
