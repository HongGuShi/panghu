package com.panghu.permission.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "用户输出", description = "用户输出")
public class SysUserVO {

    @ApiModelProperty(value = "id")
    @Column(name = "id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "username")
    private String username;

    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;

    /**
     * @ManyToMany 表示多对多关系，fetch = FetchType.EAGER配置懒加载策略为立即加载，因为多对多涉及到树形结构的第二层，
     * 使用懒加载会在使用roles对象时才去数据库查询，但是在本项目中会出现no session，暂时无法解决，所以加上次配置
     * @JoinTable name:中间表名， @joinColumn : name:在中间表中对应外键名,referencedColumnName在原先表中的主键名
     * inverseJoinColumns中的@joinColumn : name:多的另一方在中间表中对应的主键名,referencedColumnName在原先表中的主键名
     * 此处的配置表明user和role的多对多关系由user维护
     */
    @ApiModelProperty(value = "角色")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_user", joinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "id")})
    private List<SysRoleVO> sysRoles = new ArrayList<>();
}