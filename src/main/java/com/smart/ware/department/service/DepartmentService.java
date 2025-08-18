package com.smart.ware.department.service;

import com.smart.ware.company.entity.Company;
import com.smart.ware.company.repository.CompanyRepository;
import com.smart.ware.department.dto.CreateDepartmentRequest;
import com.smart.ware.department.dto.DepartmentListResponse;
import com.smart.ware.department.entity.Department;
import com.smart.ware.department.repository.DepartmentQueryRepository;
import com.smart.ware.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentQueryRepository departmentQueryRepository;
    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;


    @Transactional(readOnly = true)
    public List<DepartmentListResponse> getDepartment(String companyCode) {
        return departmentQueryRepository.findByCompanyCode(companyCode);
    }

    public String createDepartment(CreateDepartmentRequest request) {
        Company company = companyRepository.findByCompanyCode(request.companyCode()).orElseThrow(
                () -> new NoSuchElementException("회사정보가 존재 하지 않습니다.")
        );

        Department department = new Department();
        department.setDepartmentName(request.departmentName());
        department.setDepartmentCode(request.departmentCode());

        department.setCompany(company);

        return departmentRepository.save(department).getDepartmentCode();
    }
}
