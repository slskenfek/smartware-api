package com.smart.ware.login.controller;


import com.smart.ware.login.dto.LoginRequest;
import com.smart.ware.login.dto.LoginResponse;
import com.smart.ware.login.service.UserLoginService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
@RequestMapping("/api/auth/login")
@RestController
@Tag(name = "로그인", description = "로그인 관련 API 입니다.")
public class LoginController {

    private final UserLoginService userLoginService;

    @PostMapping("")
    @Operation(summary = "로그인", description = "로그인 API 입니다.")
    public ResponseEntity<ResponseAPI<LoginResponse>> userLogin(@RequestBody LoginRequest loginRequest) throws NoSuchAlgorithmException {
        LoginResponse response = userLoginService.login(loginRequest);
        return ResponseEntity.ok(ResponseAPI.success(response));

    }

}
