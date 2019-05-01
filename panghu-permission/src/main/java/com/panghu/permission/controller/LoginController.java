package com.panghu.permission.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(description = "登录")
public class LoginController {

    @ApiOperation(value = "主页")
    @GetMapping("/index")
    public String index() {
        return "/index.html";
    }

    @ApiOperation(value = "错误")
    @GetMapping("/errorPage")
    public String error() {
        return "/login-error.html";
    }
}
