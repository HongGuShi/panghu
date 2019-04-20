package com.panghu.study.entity;

import com.panghu.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "student")
@ApiModel(value = "学生", description = "学生")
public class Student extends BaseEntity {

    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "年龄")
    @Column(name = "age")
    private Integer age;

}