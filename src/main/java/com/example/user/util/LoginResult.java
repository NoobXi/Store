package com.example.user.util;

import lombok.Data;

/**
 * @author Noob
 * @date 2021/12/15 - 14:00
 */
@Data
public class LoginResult<T> {
    public LoginResult(){}

    public LoginResult(Integer code, String message, T data, Long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    //返回码
    private Integer code;
    //返回描述
    private String message;
    //返回数据
    private T data;
    //分页查询总记录
    private Long count;

    public static LoginResult<Object> success() {
        return new LoginResult(0, "success", null, null);
    }

    public static LoginResult<Object> success(String message) {
        return new LoginResult(0, message, null, null);
    }

    public static LoginResult<Object> success(Object data, Long count) {
        return new LoginResult(0, "success", data, count);
    }

    public static LoginResult<Object> fail() {
        return new LoginResult(1, "fail", null, null);
    }

    public static LoginResult<Object> fail(String message) {
        return new LoginResult(1, message, null, null);
    }
}
