package com.smart.ware.domain.company.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smart.ware.company.dto.response.QSummaryCompanyResponse;
import com.smart.ware.domain.company.dto.response.SummaryCompanyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.smart.ware.company.entity.QCompany.company;

@Repository
@RequiredArgsConstructor
public class CompanyQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<SummaryCompanyResponse> findCompanyByCompanyName(Pageable pageable, String companyName) {
        return jpaQueryFactory.select(new QSummaryCompanyResponse(
                        company.companyName,
                        company.companyCode
                ))
                .from(company)
                .where(likeCompanyName(companyName))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

    }


    private BooleanExpression likeCompanyName(String companyName) {
        if (!StringUtils.hasText(companyName)) {
            return null;
        }
        return company.companyName.contains(companyName);
    }


}
