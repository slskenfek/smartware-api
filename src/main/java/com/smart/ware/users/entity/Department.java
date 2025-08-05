package com.smart.ware.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 부서 테이블
 */
@Entity
@Table(name = "department")
@NoArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name", length = 30, nullable = false)
    private String departmentName; //부서 이름
    @Column(name = "department_code", length = 30, nullable = false)
    private String departmentCode; //부서 코드
}
