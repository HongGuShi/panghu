package com.panghu.study.controller;

import com.panghu.common.response.BaseResponse;
import com.panghu.common.utils.ResultUtil;
import com.panghu.study.dto.StudentDTO;
import com.panghu.study.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(description = "学生")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = " 新增学生信息")
    @PostMapping("insertStudentInfo")
    public BaseResponse insertStudentInfo(@RequestBody @ApiParam StudentDTO studentDTO) {
        return ResultUtil.success(studentService.insertStudentInfo(studentDTO));
    }

    @ApiOperation(value = " 删除学生信息")
    @GetMapping("deleteStudentInfo")
    public BaseResponse deleteStudentInfo(@RequestParam @ApiParam String id) {
        return ResultUtil.success(studentService.deleteStudentInfo(id));
    }

    @ApiOperation(value = " 修改学生信息")
    @PostMapping("updateStudentInfo")
    public BaseResponse updateStudentInfo(@RequestBody @ApiParam StudentDTO studentDTO) {
        return ResultUtil.success(studentService.updateStudentInfo(studentDTO));
    }

    @ApiOperation(value = " 分页查询学生信息")
    @PostMapping("pageStudentInfo")
    public BaseResponse pageStudentInfo(@RequestBody @ApiParam StudentDTO studentDTO) {
        return ResultUtil.success(studentService.pageStudentInfo(studentDTO));
    }

}
