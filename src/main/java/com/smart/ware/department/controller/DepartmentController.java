package com.smart.ware.department.controller;

import com.smart.ware.department.dto.DepartmentListResponse;
import com.smart.ware.department.service.DepartmentService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
@Tag(name = "부서 조회", description = "부서 조회 하는 API 입니다.")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{companyCode}")
    @Operation(summary = "회사 코드로 부서 조회", description = "회사 코드로 부서를 조회하는 API 입니다.")
    public ResponseEntity<ResponseAPI<List<DepartmentListResponse>>> getDepartment(@PathVariable String companyCode) {
        List<DepartmentListResponse> departmentList = departmentService.getDepartment(companyCode);
        return ResponseEntity.ok(ResponseAPI.success(departmentList));
    }
}
