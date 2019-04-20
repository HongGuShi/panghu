package com.panghu.common.enums;

/**
 * @author: 胖虎
 * @version: v1.0.0
 * @description: 功能描述: 业务错误码定位
 * @createTime: 2019/4/20 16:58
 */
public enum ResultEnum {

    SUCCESS("200"),//成功
    ERROR("50000"),//服务器繁忙，请稍后重试
    PARAMETER_IS_NOT_PRESENT("50002"),//输入参数不能为空
    REQUEST_REMOTE_ERROR("52002"),//服务内部错误
    USER_OR_PASSWORD_INCORRECT("52004"),//用户名或密码不正确
    USER_NOT_ENABLE("52005");//用户名已禁用

    private String code;

    private ResultEnum() {
    }

    private ResultEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
