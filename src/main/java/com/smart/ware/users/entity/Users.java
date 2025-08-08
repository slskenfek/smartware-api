package com.smart.ware.users.entity;

import com.smart.ware.company.entity.Company;
import com.smart.ware.department.entity.Department;
import com.smart.ware.roles.entity.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 유저 테이블
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 50, nullable = false)
    private String userId; // 유저 아이디

    @Column(name = "user_name", length = 10, nullable = false)
    private String userName; // 유저 이름

    @Column(name = "password", length = 99, nullable = false)
    private String password; // 비밀번호

    @Column(name = "gender", length = 2, nullable = false)
    private String gender; // 성별

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department; //부서


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Roles roles;

}
