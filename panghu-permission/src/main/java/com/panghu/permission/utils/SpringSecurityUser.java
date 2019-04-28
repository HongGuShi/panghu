package com.panghu.permission.utils;

import com.panghu.permission.vo.SysUserVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
public class SpringSecurityUser implements UserDetails, Serializable {

    @ApiModelProperty("用户")
    private SysUserVO sysUserVO;

    @ApiModelProperty("用户权限")
    private Collection<? extends GrantedAuthority> authorities;

    @ApiModelProperty("权限是否过期")
    private boolean credentialsNonExpired = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return sysUserVO.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUserVO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {//账户是否过期
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {//账户是否被锁
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {//证书是否过期
        return false;
    }

    @Override
    public boolean isEnabled() {//是否禁用
        return false;
    }
}
