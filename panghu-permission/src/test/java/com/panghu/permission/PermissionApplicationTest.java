package com.panghu.permission;

import com.panghu.permission.controller.LoginController;
import com.panghu.permission.dao.SysUserMapper;
import com.panghu.permission.entity.SysUser;
import com.panghu.permission.vo.SysUserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionApplicationTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoad() {
    }
}
