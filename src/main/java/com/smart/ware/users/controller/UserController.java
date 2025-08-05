package com.smart.ware.users.controller;

import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "유저 관리", description = "유저 조회/등록/수정/삭제 하는 API 입니다.")
public class UserController {

    private final UserService userService;


    @PostMapping("")
    @Operation(summary = "유저 등록", description = "유저 등록 할수 있는 API 입니다."
            , parameters = {
            @Parameter(name = "departmentName", description = "부서명"),
            @Parameter(name = "userId", description = "유저 아이디"),
            @Parameter(name = "userName", description = "유저 이름"),
            @Parameter(name = "password", description = "비밀번호"),
            @Parameter(name = "gender", description = "성별"),
            @Parameter(name = "companyCode", description = "회사 코드, 미리 조회된 회사 정보 데이터 안에 있는 값으로 요청 해야합니다."),
    }
    )
    public ResponseEntity<Boolean> createUsers(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUsers(createUserRequest);
        return ResponseEntity.ok(true);
    }

}
