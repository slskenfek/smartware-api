package com.smart.ware.users.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final PasswordEncoder passwordEncoder;


    public String passwordEncode(String password) {
        return passwordEncoder.encode(password);
    }

}
