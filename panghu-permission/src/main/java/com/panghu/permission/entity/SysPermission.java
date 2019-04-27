package com.panghu.permission.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sys_permission")
@ApiModel(value = "权限", description = "权限")
public class SysPermission {

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