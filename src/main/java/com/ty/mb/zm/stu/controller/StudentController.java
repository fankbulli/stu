package com.ty.mb.zm.stu.controller;


import com.ty.mb.zm.stu.entity.Student;
import com.ty.mb.zm.stu.service.StudentService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 钟鸣
 * @since 2020-05-27
 */
@RestController

@ApiModel(value = "学生表")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "学生列表",tags = "学生表")
    @GetMapping("/list")
    public List<Student> queryList(){
        List<Student> list=studentService.list();
        return list;
    }

    @ApiOperation(value = "根据sno查找学生",tags = "学生表")
    @GetMapping("/findBySno/{sno}")
    public Student findBySno(@PathVariable Integer sno){
        Student stu=studentService.getById(sno);
        return stu;
    }

}

