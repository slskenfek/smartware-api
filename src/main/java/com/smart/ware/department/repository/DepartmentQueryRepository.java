package com.smart.ware.department.repository;


import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smart.ware.department.dto.DepartmentListResponse;
import com.smart.ware.department.dto.QDepartmentListResponse;
import com.smart.ware.department.entity.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.smart.ware.department.entity.QDepartment.department;

@Repository
@RequiredArgsConstructor
public class DepartmentQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<DepartmentListResponse> findByCompanyCode(String companyCode) {
        return jpaQueryFactory.select(
                        new QDepartmentListResponse(
                                department.id,
                                department.departmentName,
                                department.departmentCode
                        )
                )
                .from(department)
                .innerJoin(department.company)
                .where(department.company.companyCode.eq(companyCode))
                .fetch();
    }
}
