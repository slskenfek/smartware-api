package com.smart.ware.department.service;

import com.smart.ware.department.dto.DepartmentListResponse;
import com.smart.ware.department.repository.DepartmentQueryRepository;
import com.smart.ware.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    public final DepartmentQueryRepository departmentQueryRepository;

    @Transactional(readOnly = true)
    public List<DepartmentListResponse> getDepartment(String companyCode) {
        return departmentQueryRepository.findByCompanyCode(companyCode);
    }
}
