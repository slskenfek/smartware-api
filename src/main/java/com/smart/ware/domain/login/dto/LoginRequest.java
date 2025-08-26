package com.smart.ware.domain.login.dto;

public record LoginRequest(
        String userId,
        String password
) {
}
