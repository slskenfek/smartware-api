package com.smart.ware.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreateCompanyRequest {

    private String companyName; //회사 이름

    private String companyCode; //회사 코드

    private String ceoName; //대표 이름

    private String address; //회사 주소

    private String email; // 대표 이메일

    private String businessNumber; // 사업자 등록 번호

    private String logoUrl; // 로고 주소

    private String useYn; //사용 여부


}
