package com.smart.ware.domain.token.domain;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "app.jwt")
public record JwtProps(
        String issuer,
        String secret,
        String algorithm,
        Duration accessTtl,
        Duration refreshTtl
) {
}
