package com.smart.ware.company.dto.request;

import com.smart.ware.company.entity.Company;

import java.util.UUID;

public record CreateCompanyRequest(
        String companyName, //회사 이름

        String companyCode, //회사 코드

        String ceoName, //대표 이름

        String address, //회사 주소

        String email, // 대표 이메일

        String businessNumber, // 사업자 등록 번호

        String logoUrl, // 로고 주소

        String useYn //사용 여부
) {


    public Company toEntity() {
        return Company.builder()
                .companyName(companyName)
                .address(address)
                .companyCode(UUID.randomUUID().toString())
                .companyCode(companyCode)
                .businessNumber(businessNumber)
                .email(email)
                .ceoName(ceoName)
                .useYn(useYn)
                .logoUrl(logoUrl)
                .build();
    }
}
