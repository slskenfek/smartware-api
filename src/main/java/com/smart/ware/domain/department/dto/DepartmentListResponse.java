package com.smart.ware.domain.department.dto;

import com.querydsl.core.annotations.QueryProjection;

public record DepartmentListResponse(
        Long id,
        String departmentName, //부서 이름
        String departmentCode //부서 코드
) {

    @QueryProjection
    public DepartmentListResponse(Long id, String departmentName, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }
}

