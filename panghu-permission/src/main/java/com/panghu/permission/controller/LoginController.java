package com.panghu.permission.controller;

import com.panghu.permission.dao.SysUserMapper;
import com.panghu.permission.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Api(description = "登录")
public class LoginController {

    @Autowired
    private SysUserMapper sysUserMapper;

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

    public static void main(String[] args) {
////        int j = 2;
////        int value = 3;
////        int[] arr = {1, 2, 4, 5, 6};
////        for (int i = arr.length - 1; i > j - 1; i--) {
////            arr[i] = arr[i - 1];
////        }
////        arr[j] = value;
////        for (int i : arr) {
////            System.out.println(i);
////        }
//        int index = 2;
//        int value = 5;
//        int[] array = new int[]{4, 2, 3, 1};
//        int[] newArray = new int[array.length + 1];
////        for (int i = 0; i < array.length; i++) {
////            newArray[i] = array[i];
////        }
////        for (int i = newArray.length - 1; i > index; i--) {
////            newArray[i] = newArray[i - 1];
////        }
////        newArray[index] = value;
////        array = newArray;
////        System.out.println(Arrays.toString(array));
//
//        //反转
////        for (int i = 0; i < array.length / 2; i++) {
////            int temp = array[i];
////            array[i] = array[array.length - i - 1];
////            array[array.length - i - 1] = temp;
////        }
////        System.out.println(Arrays.toString(array));
//        int minValue = array[0];
//        int maxValue = array[0];
//        int minId = 0;
//        int maxId = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (minValue > array[i]) {
//                minValue = array[i];
//                minId = i;
//            }
//            if (maxValue < array[i]) {
//                maxValue = array[i];
//                maxId = i;
//            }
//        }
//        System.out.println(minValue);
//        System.out.println(minId);
//        System.out.println(maxValue);
//        System.out.println(maxId);


        char c = 'a' + 65535 - 97;
        System.out.println(c);


    }
}
