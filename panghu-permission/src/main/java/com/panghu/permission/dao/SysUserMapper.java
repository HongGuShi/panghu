package com.panghu.permission.dao;

import com.panghu.permission.entity.SysUser;
import com.panghu.permission.vo.SysUserVO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser>{

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    SysUserVO selectByUsername(String username);
}