package com.panghu.permission.controller;

import com.panghu.permission.entity.Msg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(description = "权限")
public class PermissionController {

//    @ApiOperation(value = "主页")
//    @GetMapping("/")
//    public String home() {
//        return "Hello Spring Boot!";
//    }

//    @ApiOperation(value = "欢迎页面")
//    @GetMapping("/hello")
//    public String hello() {
//        return "欢迎来到欢迎界面";
//    }
//
//    @PreAuthorize("hasRole('ROLE_ADMIN')")//用来标识只有固定的角色才可以访问
//    @ApiOperation(value = "认证")
//    @GetMapping("/auth")
//    public String auth() {
//        return "您是管理员身份";
//    }
//
//    @RequestMapping("/whoIm")
//    public Object whoIm() {//用户信息是存在SecurityContextHolder 的全局变量中，所以我们可以这样获取
//        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }


    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "home";
    }
}
