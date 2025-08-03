package com.smart.ware.users.controller;

import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("")
    public ResponseEntity<Boolean> createUsers(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUsers(createUserRequest);
        return ResponseEntity.ok(true);
    }

}
