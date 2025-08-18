package com.smart.ware.users.service.factory;

import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.entity.Users;
import com.smart.ware.users.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * 유저 조립 담당
 * 우선 기본 유저만 생성 한다는 정책만 적용
 * 추후 관리자 계정 정책
 * 일회성 계정 정책 등등 추가 되면 확장 유연하도록 설계
 */
@Component
@RequiredArgsConstructor
public class UserFactory {


    private final UserAuthService userAuthService;


    public Users createUser(CreateUserRequest request) {
        request.setPassword(userAuthService.passwordEncode(request.getPassword()));
        return createUserEntity(request);
    }

    private Users createUserEntity(CreateUserRequest request) {

        Users users = new Users();
        users.setUserId(request.getUserId());
        users.setUserName(request.getUserName());
        users.setGender(request.getGender());
        users.setPassword(request.getPassword());
        return users;
    }

}
