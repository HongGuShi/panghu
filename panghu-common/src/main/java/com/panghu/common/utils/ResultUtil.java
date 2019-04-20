package com.panghu.common.utils;

import com.panghu.common.enums.ResultEnum;
import com.panghu.common.response.BaseResponse;

/**
 * @author: 胖虎
 * @version: v1.0.0
 * @description: 功能描述: 响应结果工具类
 * @createTime: 2019/4/20 16:58
 */
public class ResultUtil {
    /**
     * @description: 功能描述: 操作成功返回信息
     * @author 胖虎
     * @createTime 2019/4/20 16:58
     */
    public static BaseResponse success(Object object) {
        BaseResponse response = new BaseResponse();
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg("SUCCESS");
        response.setData(object);
        return response;
    }

    /**
     * @description: 功能描述: 操作成功不返回消息
     * @author 胖虎
     * @createTime 2019/4/20 16:58
     */
    public static BaseResponse success() {
        return ResultUtil.success(null);
    }

    /**
     * @description: 功能描述: 操作失败返回的消息
     * @author 胖虎
     * @createTime 2019/4/20 16:58
     */
    public static BaseResponse error(String code, String msg) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

}
