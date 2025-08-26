package com.smart.ware.domain.company.repository;

import com.smart.ware.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

     Optional<Company> findByCompanyCode(String companyCode);
}
