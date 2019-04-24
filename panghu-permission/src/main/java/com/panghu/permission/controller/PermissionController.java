package com.panghu.permission.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "权限")
public class PermissionController {

    @ApiOperation(value = "主页")
    @GetMapping("/")
    public String home() {
        return "Hello Spring Boot!";
    }

    @ApiOperation(value = "欢迎页面")
    @GetMapping("/hello")
    public String hello() {
        return "欢迎来到欢迎界面";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")//用来标识只有固定的角色才可以访问
    @ApiOperation(value = "认证")
    @GetMapping("/auth")
    public String auth() {
        return "您是管理员身份";
    }

}
