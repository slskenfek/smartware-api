package com.smart.ware.domain.token.dto;

import java.time.LocalDateTime;

public record TokenManager(
        String accessToken,
        String refreshToken,
        LocalDateTime refreshTokenTime
) {
}
