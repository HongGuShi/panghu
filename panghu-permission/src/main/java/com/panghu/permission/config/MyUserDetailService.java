package com.panghu.permission.config;

import com.panghu.permission.dao.SysUserMapper;
import com.panghu.permission.vo.SysRoleVO;
import com.panghu.permission.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户
        SysUserVO sysUserVO = sysUserMapper.selectByUsername(username);
        if (sysUserVO == null) {
            throw new RuntimeException("用户名不存在");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();//认证权限集合
        List<SysRoleVO> sysRoles = sysUserVO.getSysRoles();//角色集合
//        for (SysRoleVO sysRole : sysRoles) {
//            List<SysPermissionVO> sysPermissionVOS = sysRole.getSysPermissionVOS();//角色的权限集合
//            for (SysPermissionVO sysPermissionVO : sysPermissionVOS) {
////                //为每个授权中心对象写入权限名
//        grantedAuthorities.add(new SimpleGrantedAuthority("1"));
//            }
//        }
        for (SysRoleVO sysRole : sysRoles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        return new User(sysUserVO.getUsername(), sysUserVO.getPassword(), grantedAuthorities);
//        SpringSecurityUser springSecurityUser = new SpringSecurityUser();
//        springSecurityUser.setSysUserVO(sysUserVO);
//        springSecurityUser.setAuthorities(grantedAuthorities);
//        return springSecurityUser;
    }
}
