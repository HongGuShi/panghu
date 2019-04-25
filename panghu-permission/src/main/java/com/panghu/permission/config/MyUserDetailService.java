package com.panghu.permission.config;

import com.panghu.permission.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //这里可以可以通过username（登录时输入的用户名）然后到数据库中找到对应的用户信息，并构建成我们自己的UserInfo来返回。

        //这里可以通过数据库来查找到实际的用户信息，这里我们先模拟下,后续我们用数据库来实现
        if (username.equals("admin")) {
            //假设返回的用户信息如下;
            UserInfo userInfo = new UserInfo("admin", "123456", "ROLE_ADMIN", true, true, true, true);
            return userInfo;
        }
        return null;
    }
}
