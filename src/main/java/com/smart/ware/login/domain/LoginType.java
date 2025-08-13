package com.smart.ware.login.domain;


import com.smart.ware.exception.BadRequestException;

public enum LoginType {
    BASIC;

    public static LoginType fromCode(String header) {
        try {
            return LoginType.valueOf(header.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new BadRequestException("Login-Service 요청 타입을 확인해 주세요. " + header + " , msg =" + e.getMessage());
        }
    }


}
