package com.smart.ware.users.service;

import com.smart.ware.company.entity.Company;
import com.smart.ware.company.repository.CompanyRepository;
import com.smart.ware.department.entity.Department;
import com.smart.ware.department.repository.DepartmentRepository;
import com.smart.ware.users.dto.CreateUserRequest;
import com.smart.ware.users.dto.PatchUserRequest;
import com.smart.ware.users.dto.UserView;
import com.smart.ware.users.entity.Users;
import com.smart.ware.users.exception.DuplicateUserIdException;
import com.smart.ware.users.repository.UserQueryRepository;
import com.smart.ware.users.repository.UserRepository;
import com.smart.ware.users.service.factory.UserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public void register(CreateUserRequest createUserRequest) {
        existUser(createUserRequest.getUserId());
        Users createUser = userFactory.createUser(createUserRequest);
        userRepository.save(createUser);
    }

    @Transactional
    public void update(String userId, PatchUserRequest patchUserRequest) {
        Users users = userRepository.findByUserId(userId).orElseThrow(
                () -> new NoSuchElementException("유저 정보가 존재하지 않습니다.")
        );
        Company company = companyRepository.findByCompanyCode(patchUserRequest.companyCode()).orElseThrow(
                () -> new NoSuchElementException("회사 정보가 존재하지 않습니다.")
        );
        Department department = departmentRepository.findByDepartmentCode(patchUserRequest.departmentCode()).orElseThrow(
                () -> new NoSuchElementException("부서 정보가 존재 하지 않습니다.")
        );
        department.setCompany(company);
        users.setDepartment(department);
    }

    public void existUser(String userId) {
        boolean existUser = userRepository.existsByUserId(userId);
        if (existUser) {
            throw new DuplicateUserIdException(userId);
        }
    }
}
