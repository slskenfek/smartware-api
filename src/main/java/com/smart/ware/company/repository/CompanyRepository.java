package com.smart.ware.company.repository;

import com.smart.ware.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

     Optional<Company> findByCompanyCode(String companyCode);
}
