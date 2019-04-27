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
    private boolean credentialsNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
