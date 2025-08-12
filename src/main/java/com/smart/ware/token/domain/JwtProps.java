package com.smart.ware.token.domain;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "app.jwt")
public record JwtProps(
        String issuer,
        Duration accessTtl,
        Duration refreshTtl
) {
}
