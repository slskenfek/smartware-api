package com.smart.ware.users.service;


import com.smart.ware.exception.BadRequestException;
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

    public boolean matches(String password, String encodePassword) {
        if (password == null || encodePassword == null)
            throw new BadRequestException("password check" + password + "in" + encodePassword);
        return passwordEncoder.matches(password, encodePassword);
    }

}
