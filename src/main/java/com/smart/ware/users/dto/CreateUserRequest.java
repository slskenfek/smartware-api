package com.smart.ware.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String departmentName;

    private String userId; // 유저 아이디

    private String userName; // 유저 이름

    private String password; // 비밀번호

    private String gender; // 성별

    private String companyCode; // 회사 코드
}
