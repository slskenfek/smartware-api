package com.smart.ware.users.dto;

import java.util.List;

public record UserResponse(
        Long id,
        String userId,
        String password,
        List<String> roles
) {
}
