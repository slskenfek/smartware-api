package com.smart.ware.login.dto;

public record LoginRequest(
        String userId,
        String password
) {
}
