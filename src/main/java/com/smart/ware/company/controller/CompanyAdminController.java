package com.smart.ware.company.controller;

import com.smart.ware.company.dto.CreateCompanyRequest;
import com.smart.ware.company.service.CompanyAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/admin/company")
@RequiredArgsConstructor
@Tag(name = "그룹(회사)", description = "그룹 관련 API 입니다. 사전 등록된 그룹 관리자만 사용 할 수 있습니다.")
public class CompanyAdminController {

    private final CompanyAdminService companyAdminService;

    @PostMapping("")
    @Operation(summary = "그룹(회사)등록", description = "그룹 등록 하는 API 입니다. admin 계정만 접근 가능합니다.")
    public ResponseEntity<Boolean> createCompany(@RequestBody CreateCompanyRequest request) {
        Long createId = companyAdminService.createCompany(request);
        URI location = URI.create("/api/admin/company/" + createId);
        return ResponseEntity.created(location).build();
    }
}
