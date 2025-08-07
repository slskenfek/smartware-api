package com.smart.ware.company.service;


import com.smart.ware.company.dto.CreateCompanyRequest;
import com.smart.ware.company.entity.Company;
import com.smart.ware.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyAdminService {

    private final CompanyRepository companyRepository;


    public Long createCompany(CreateCompanyRequest request) {
        Company createCompany = companyRepository.save(request.toEntity());
        return createCompany.getId();
    }
}
