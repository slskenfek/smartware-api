package com.smart.ware.response;

public class ResponseAPI<T> {

    private final Integer code;
    private final String message;
    private final T data;

    private ResponseAPI(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseAPI<T> success(T data) {
        return new ResponseAPI<>(200, "success", data);
    }

    public static <T> ResponseAPI<T> created(T data) {
        return new ResponseAPI<>(201, "success", data);
    }
}
