package com.panghu.permission.entity;

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
@Entity
@Table(name = "sys_role")
@ApiModel(value = "角色", description = "角色")
public class SysRole {

    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private Integer id;

    @ApiModelProperty(value = "名称")
    @Column(name = "name")
    private String name;


}