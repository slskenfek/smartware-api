package com.smart.ware.company.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", length = 50, nullable = false)
    private String companyName; //회사 이름

    @Column(name = "company_code", length = 20, nullable = false)
    private String companyCode; //회사코드

    @Column(name = "ceo_name", length = 10, nullable = false)
    private String ceoName; //대표 이름

    @Column(name = "address", length = 100)
    private String address; //회사 주소

    @Column(name = "email", length = 55)
    private String email; // 대표 이메일

    @Column(name = "business_number", length = 20, nullable = false)
    private String businessNumber; // 사업자 등록 번호

    @Column(name = "logo_url", length = 300)
    private String logoUrl; // 로고 주소

    @Column(name = "use_yn", length = 1)
    private String useYn; //사용 여부

    @Builder
    public Company(String companyName, String companyCode, String ceoName, String address, String email, String businessNumber, String logoUrl, String useYn) {
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.ceoName = ceoName;
        this.address = address;
        this.email = email;
        this.businessNumber = businessNumber;
        this.logoUrl = logoUrl;
        this.useYn = useYn;
    }
}
