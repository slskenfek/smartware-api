package com.smart.ware.users;

import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    @DisplayName("사용자 정보를 등록 한다.")
    void createUsers() {
        CreateUserRequest request = new CreateUserRequest();

        request.setUserId("slskenfek");
        request.setUserName("kim");
        request.setGender("M");
        request.setPassword("ABCDEFD");
        userService.createUsers(request);
    }

}
