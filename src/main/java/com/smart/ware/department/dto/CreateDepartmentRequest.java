package com.smart.ware.department.dto;


public record CreateDepartmentRequest(
        String departmentName,
        String departmentCode,
        String companyCode
) {

}
