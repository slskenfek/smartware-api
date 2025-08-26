package com.smart.ware.domain.users.dto;

public record PatchUserRequest(
        String companyCode,
        String departmentCode
) {
}
