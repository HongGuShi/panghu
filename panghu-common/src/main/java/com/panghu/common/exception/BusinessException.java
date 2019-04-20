package com.panghu.common.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 7780291076367953235L;

    //返回码
    private String code;

    public BusinessException(String code) {
        this.code = code;
    }

    //自定义验证失败
    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
