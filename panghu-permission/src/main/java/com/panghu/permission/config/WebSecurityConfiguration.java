package com.panghu.permission.config;

import com.panghu.permission.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//判断用户对某个控制层的方法是否具有访问权限
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationProvider provider;

//    @Autowired
//    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
//
//    @Autowired
//    private AuthenticationFailureHandler myAuthenticationFailHandler;

    @Autowired
    @Qualifier(value = "myUserDetailService")
    private UserDetailsService userDetailsService;

    /**
     * case1:只需要登录即可
     * case2:有指定的角色,每个角色有指定权限
     * 此方法可以实现将登录的用户名和密码在java代码中去配置,不使用数据库
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置一个用户角色,可配置多个,Spring Security在5.0版本之后,不允许明文密码,所以要使用passwordEncoder方法和BCryptPasswordEncoder类进行加密
        //auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");//管理员用户
        //auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("james").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");//普通用户
        //auth.authenticationProvider(provider);
        auth.userDetailsService(userDetailsService)//将用户认证与数据库集成
                .passwordEncoder(new PasswordEncoder() {//指定密码加密匹配模式
                    @Override
                    public String encode(CharSequence rawPassword) {
                        return MD5Util.encode((String) rawPassword);
                    }

                    @Override
                    public boolean matches(CharSequence rawPassword, String encodedPassword) {
                        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
                    }
                });
    }

    /**
     * `
     * 此重写方法用于配置不需要进行认证的资源
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/swagger-resources", "/configuration/ui");//Swagger主页以及Swagger样式不拦截
    }

    /**
     * 此方法用于配置需要拦截的http请求
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置拦截策略
/*        http.authorizeRequests()
                .antMatchers("/").permitAll()//根路径允许访问
                .anyRequest().authenticated()//其他请求必须经过认证
                .and() //拼接条件
                .logout().permitAll()//注销允许访问
                .and() //拼接条件
                .formLogin()//form表单登录放行
                //.loginPage("/login")
//                .successHandler(myAuthenticationSuccessHandler)//成功响应
//                .failureHandler(myAuthenticationFailHandler)//失败响应
                .permitAll();
        //关闭security自带的csrf跨域拦截//
        http.csrf().disable();*/

        //自定义登陆页面
        http.formLogin()
                //登陆成功后跳转的页面
                //.defaultSuccessUrl("/index")
                //登陆失败或无权限跳转页面
                //.failureUrl("/errorPage")
                .permitAll()
                //其他所有页面必须验证后才可以访问
                .and().authorizeRequests().anyRequest().authenticated()
                //不加上不验证。不知道为什么
                .and().csrf().disable();
    }
}
