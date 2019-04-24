package com.panghu.permission;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
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

    @Test
    public void contextLoad() {
    }

}
