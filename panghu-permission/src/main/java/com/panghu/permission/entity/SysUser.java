package com.panghu.permission.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sys_user")
@ApiModel(value = "用户", description = "用户")
public class SysUser {

    @ApiModelProperty(value = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "username")
    private String username;

    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;

}