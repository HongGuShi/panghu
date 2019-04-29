package com.panghu.permission.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
@ApiModel(value = "角色输出", description = "角色输出")
public class SysRoleVO {

    @ApiModelProperty(value = "姓名")
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    //    /**
//     * mappedBy：映射的名字为user中role集合的名字
//     */
//    @ManyToMany(mappedBy = "sysRoles")
    @ApiModelProperty(value = "权限")
    private List<SysPermissionVO> sysPermissionVOS;
}