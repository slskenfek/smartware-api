package com.smart.ware.company.controller;

import com.smart.ware.company.dto.request.SearchCompanyRequest;
import com.smart.ware.company.dto.response.SummaryCompanyResponse;
import com.smart.ware.company.service.CompanyService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
@Tag(name = "그룹(회사) - 사용자용", description = "그룹 관련 API 입니다.")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("")
    public ResponseEntity<ResponseAPI<List<SummaryCompanyResponse>>> getCompanyByCompanyName(@RequestParam(required = false) String companyName,
                                                                                       Pageable pageable) {
        List<SummaryCompanyResponse> summaryCompanyResponse =
                companyService.getCompanyByCompanyName(pageable, companyName);
        return ResponseEntity
                .ok()
                .header("Request-Company-Name", companyName)
                .body(ResponseAPI.success(summaryCompanyResponse));
    }
}
