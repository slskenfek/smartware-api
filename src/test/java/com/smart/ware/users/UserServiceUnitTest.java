package com.smart.ware.users;

import com.smart.ware.domain.users.dto.CreateUserRequest;
import com.smart.ware.domain.users.entity.Users;
import com.smart.ware.domain.users.repository.UserRepository;
import com.smart.ware.domain.users.service.UserService;
import com.smart.ware.domain.users.service.factory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;

    @Mock
    UserFactory userFactory;
    @Mock
    PasswordEncoder passwordEncoder;



    @Test
    @DisplayName("사용자 아이디가 중복인지 체크 한후 사용자 정보를 등록 한다.")
    void exist_register() {
        when(userRepository.existsByUserId("slskenfek")).thenReturn(false);

        var request = new CreateUserRequest();
        request.setUserId("slskenfek");
        request.setUserName("kim");
        request.setGender("M");
        request.setPassword(passwordEncoder.encode("ABCDEFD"));

        userService.register(request);
        var create = new Users();
        create.setUserId("slskenfek");
        create.setUserName("kim");
        create.setGender("M");
        create.setPassword(passwordEncoder.encode("ABCDEFD"));

        when(userFactory.createUser(request)).thenReturn(create);

        userService.register(request);

        verify(userRepository, times(1)).existsByUserId("slskenfek");
        verifyNoMoreInteractions(userRepository);

    }

}
