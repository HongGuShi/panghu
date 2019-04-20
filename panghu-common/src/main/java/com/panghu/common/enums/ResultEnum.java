package com.panghu.common.enums;

/**
 * @author: 胖虎
 * @version: v1.0.0
 * @description: 功能描述: 业务错误码定位
 * @createTime: 2019/4/20 16:58
 */
public enum ResultEnum {

    SUCCESS("200"),//成功
    ERROR("50000");//服务器繁忙，请稍后重试

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
