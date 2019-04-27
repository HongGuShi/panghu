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
@ApiModel(value = "权限输出", description = "权限输出")
public class SysPermissionVO {

    @ApiModelProperty(value = "id")
    @Column(name = "id")
    private Integer id;


    @ApiModelProperty(value = "名称")
    @Column(name = "name")
    private String name;


    @ApiModelProperty(value = "描述")
    @Column(name = "description")
    private String description;


    @ApiModelProperty(value = "url")
    @Column(name = "url")
    private String url;


    @ApiModelProperty(value = "父级id")
    @Column(name = "pid")
    private Integer pid;
}