package com.smart.ware.company.dto.response;

import com.querydsl.core.annotations.QueryProjection;

public record SummaryCompanyResponse(
        String companyName,
        String companyCode
) {
    @QueryProjection
    public SummaryCompanyResponse(String companyName, String companyCode) {
        this.companyName = companyName;
        this.companyCode = companyCode;
    }
}
