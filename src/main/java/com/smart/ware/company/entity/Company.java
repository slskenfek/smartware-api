package com.smart.ware.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", length = 50, nullable = false)
    private String companyName; //회사 이름

    @Column(name = "company_code", length = 20, nullable = false)
    private String companyCode; //회사코드

}
