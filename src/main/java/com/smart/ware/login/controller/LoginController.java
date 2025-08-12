package com.smart.ware.login.controller;


import com.smart.ware.login.dto.LoginResponse;
import com.smart.ware.login.service.LoginService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/auth/login")
@RestController
@Tag(name = "로그인", description = "로그인 관련 API 입니다.")
public class LoginController {

    private final Map<String, LoginService> loginServiceMap;


    @PostMapping("")
    public ResponseEntity<ResponseAPI<LoginResponse>> userLogin(@RequestHeader("Login-Service") String serviceType) {
        LoginService loginService = loginServiceMap.get(serviceType);
        LoginResponse response = loginService.login();
        return ResponseEntity.ok(ResponseAPI.success(response));

    }

}
