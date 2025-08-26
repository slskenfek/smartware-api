package com.smart.ware.domain.users.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smart.ware.domain.users.entity.Users;
import com.smart.ware.domain.users.dto.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.smart.ware.users.entity.QUsers.users;

@Repository
@RequiredArgsConstructor
public class UserQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;


    public UserView findByUserId(String userId) {
        Users userEntity = jpaQueryFactory.select(users)
                .from(users)
                .where(users.userId.eq(userId))
                .fetchOne();

        if (userEntity == null) return null;

        return UserView.builder()
                .id(userEntity.getId())
                .password(userEntity.getPassword())
                .userId(userEntity.getUserId())
                .build();
    }

}
