package com.smart.ware.department.controller;

import com.smart.ware.department.dto.CreateDepartmentRequest;
import com.smart.ware.department.dto.DepartmentListResponse;
import com.smart.ware.department.service.DepartmentService;
import com.smart.ware.response.ResponseAPI;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    @Operation(summary = "부서 등록", description = "부서 등록 하는 API 입니다.",
            parameters = {
                    @Parameter(name = "departmentName", description = "부서명"),
                    @Parameter(name = "departmentCode", description = "부서코드"),
                    @Parameter(name = "companyCode", description = "회사 코드")
            }
    )
    public ResponseEntity<ResponseAPI<String>> createDepartment(@RequestBody CreateDepartmentRequest request) {
        String department = departmentService.createDepartment(request);
        return ResponseEntity.ok(ResponseAPI.success(department));
    }
}
