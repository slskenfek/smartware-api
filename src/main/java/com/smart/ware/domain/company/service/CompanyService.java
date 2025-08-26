package com.smart.ware.domain.company.service;

import com.smart.ware.domain.company.dto.response.SummaryCompanyResponse;
import com.smart.ware.domain.company.repository.CompanyQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {


    private final CompanyQueryRepository companyQueryRepository;

    @Transactional(readOnly = true)
    public List<SummaryCompanyResponse> getCompanyByCompanyName(Pageable pageable, String companyName) {
        return companyQueryRepository.findCompanyByCompanyName(pageable, companyName);
    }


}
