package com.smart.ware.company.controller;

import com.smart.ware.company.dto.CreateCompanyRequest;
import com.smart.ware.company.service.CompanyAdminService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(summary = "그룹(회사)등록", description = "그룹 등록 하는 API 입니다. admin 계정만 접근 가능합니다.",
            parameters = {
                    @Parameter(name = "companyName", description = "회사 이름", required = true),
                    @Parameter(name = "companyCode", description = "회사 코드", required = true),
                    @Parameter(name = "ceoName", description = "대표 이름", required = true),
                    @Parameter(name = "address", description = "회사 주소"),
                    @Parameter(name = "email", description = "대표 이메일"),
                    @Parameter(name = "businessNumber", description = "사업자 등록 번호", required = true),
                    @Parameter(name = "logoUrl", description = "로고 주소"),
                    @Parameter(name = "useYn", description = "사용 여부", required = true),
            }
    )
    public ResponseEntity<ResponseAPI<Long>> createCompany(@RequestBody CreateCompanyRequest request) {
        Long createId = companyAdminService.createCompany(request);
        URI location = URI.create("/api/admin/company/" + createId);
        return ResponseEntity.created(location).body(ResponseAPI.created(createId));
    }
}
