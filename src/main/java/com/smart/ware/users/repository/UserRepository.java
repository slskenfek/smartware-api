package com.smart.ware.users.repository;

import com.smart.ware.users.dto.UserResponse;
import com.smart.ware.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    UserResponse findByUserId(String userId);
}
