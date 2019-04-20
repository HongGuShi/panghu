package com.panghu.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    private static final long serialVersionUID = -6153048148601751741L;

    @Id
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    @GeneratedValue(generator = "UUID")
    public String id;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    public Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    @ApiModelProperty(value = "创建者")
    @Column(name = "creator")
    private String creator;

    @ApiModelProperty(value = "更改者")
    @Column(name = "modifier")
    private String modifier;

    @ApiModelProperty(value = "备注")
    @Column(name = "remark")
    private String remark;

}
