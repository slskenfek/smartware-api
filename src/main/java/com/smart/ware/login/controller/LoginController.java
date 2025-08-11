package com.smart.ware.login.controller;


import com.smart.ware.login.service.LoginService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api/login")
@RestController
@Tag(name = "로그인", description = "로그인 관련 API 입니다.")
public class LoginController {

    private final Map<String, LoginService> loginServiceMap;



    public ResponseEntity<ResponseAPI<>> userLogin() {
        loginServiceMap.get("userService");
    }

}
