package com.smart.ware.domain.department.dto;


public record CreateDepartmentRequest(
        String departmentName,
        String departmentCode,
        String companyCode
) {

}
