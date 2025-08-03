package com.smart.ware.users.service;

import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUsers(CreateUserRequest createUserRequest) {


    }
}
