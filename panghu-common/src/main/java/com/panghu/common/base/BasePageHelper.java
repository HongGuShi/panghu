package com.panghu.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BasePageHelper implements Serializable {

    private static final long serialVersionUID = -7068361700500939655L;

    @ApiModelProperty("页码")
    public Integer pageNum = 1;

    @ApiModelProperty("每页条数")
    public Integer pageSize = 2;

    @ApiModelProperty("排序字段")
    public String sort = "create_time";

    @ApiModelProperty("排序方向")
    public String order = "desc";

    public static void main(String[] args) {
        int i = -2 % 3;
        System.out.println(i);
    }
}

