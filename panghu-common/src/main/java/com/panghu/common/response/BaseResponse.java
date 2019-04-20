package com.panghu.common.response;

import lombok.Data;

@Data
public class BaseResponse {

    //错误码
    private String code;

    //信息描述
    private String msg;

    //具体的信息内容
    private Object data;

}


