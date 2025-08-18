package com.smart.ware.users.controller;

import com.smart.ware.response.ResponseAPI;
import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.dto.PatchUserRequest;
import com.smart.ware.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "유저 관리", description = "유저 조회/등록/수정/삭제 하는 API 입니다.")
public class UserController {

    private final UserService userService;


    @PostMapping("")
    @Operation(summary = "유저 등록", description = "유저 등록 할수 있는 API 입니다."
            , parameters = {
            @Parameter(name = "userId", description = "유저 아이디"),
            @Parameter(name = "userName", description = "유저 이름"),
            @Parameter(name = "password", description = "비밀번호"),
            @Parameter(name = "gender", description = "성별"),
    }
    )
    public ResponseEntity<Boolean> createUsers(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUsers(createUserRequest);
        return ResponseEntity.ok(true);
    }


    @PatchMapping("/{userId}/company")
    @Operation(summary = "유저 정보 수정", description = "회사 및 부서 정보 수정 하는 API 입니다." +
            " 회사와 부서는 선 등록 되어있는 상태라 조회해서 code값을 보내면 됩니다.",
            parameters = {
                    @Parameter(name = "companyCode", description = "회사 코드"),
                    @Parameter(name = "departmentCode", description = "부서 이름")
            }
    )
    public ResponseEntity<ResponseAPI<Boolean>> changeUsers(@PathVariable String userId,
                                                            @RequestBody PatchUserRequest patchUserRequest) {
        userService.changeUsers(userId, patchUserRequest);
        return ResponseEntity.ok(ResponseAPI.success(true));
    }

}
