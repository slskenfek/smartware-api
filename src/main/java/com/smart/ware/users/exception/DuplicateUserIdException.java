package com.smart.ware.users.exception;

public class DuplicateUserIdException extends RuntimeException {
    public DuplicateUserIdException(String userId) {
        super("이미 존재하는 사용자 아이디 입니다." + userId);
    }
}
