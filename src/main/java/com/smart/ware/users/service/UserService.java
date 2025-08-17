package com.smart.ware.users.service;

import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.dto.UserView;
import com.smart.ware.users.entity.Users;
import com.smart.ware.users.repository.UserRepository;
import com.smart.ware.users.service.factory.UserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public final UserFactory userFactory;


    public void createUsers(CreateUserRequest createUserRequest) {
        Users user = userFactory.createUser(createUserRequest);
        userRepository.save(user);
    }

}
