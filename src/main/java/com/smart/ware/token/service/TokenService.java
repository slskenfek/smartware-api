package com.smart.ware.token.service;


import com.smart.ware.token.domain.RandomToken;
import com.smart.ware.token.domain.JwtProps;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.HexFormat;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {


    private final JwtEncoder jwtEncoder;

    private final JwtProps jwtProps;


    public String createAccessToken(Authentication authentication) {
        Instant now = Instant.now();
        String subject = authentication.getName();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(a -> a.replace("ROLE_", ""))
                .toList();

        var claims = JwtClaimsSet.builder()
                .issuer(jwtProps.issuer())
                .issuedAt(now)
                .expiresAt(now.plus(jwtProps.accessTtl()))
                .subject(subject)
                .claim("roles", roles)
                .claim("jti", UUID.randomUUID().toString())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public String createRefreshToken() throws NoSuchAlgorithmException {
        String token = RandomToken.create32();
        return HexFormat.of().formatHex(
                MessageDigest.getInstance("SHA-256").digest(token.getBytes(StandardCharsets.UTF_8))
        );

    }

}
