package com.panghu.permission.dao;

import com.panghu.permission.vo.SysUserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    SysUserVO selectByUsername(String username);
}