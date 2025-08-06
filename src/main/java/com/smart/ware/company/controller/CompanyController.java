package com.smart.ware.company.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "그룹(회사)", description = "그룹 관련 API 입니다. 모든 사용자가 이용 가능 합니다.")
public class CompanyController {


}
