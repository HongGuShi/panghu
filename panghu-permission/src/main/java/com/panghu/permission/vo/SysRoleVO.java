package com.panghu.permission.vo;

import com.panghu.permission.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "角色输出", description = "角色输出")
public class SysRoleVO {

    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private Integer id;

    @ApiModelProperty(value = "名称")
    @Column(name = "name")
    private String name;

    /**
     * mappedBy：映射的名字为user中role集合的名字
     */
    @ApiModelProperty(value = "用户")
    @ManyToMany(mappedBy = "sysRoles")
    private List<SysPermissionVO> sysPermissionVOS = new ArrayList<>();
}