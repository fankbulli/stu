package com.ty.mb.zm.stu.controller;


import com.ty.mb.zm.stu.entity.Teacher;
import com.ty.mb.zm.stu.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "教师列表",tags = "教师表")
    @GetMapping("/list")
    public List<Teacher> queryList(){
        List<Teacher> list=teacherService.list();
        return list;
    }

    @ApiOperation(value = "根据sno查找教师",tags = "教师表")
    @GetMapping("/findBySno/{sno}")
    public Teacher findBySno(@PathVariable Integer sno){
        Teacher tea=teacherService.getById(sno);
        return tea;
    }
}

