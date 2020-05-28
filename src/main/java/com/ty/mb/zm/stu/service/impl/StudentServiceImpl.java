package com.ty.mb.zm.stu.service.impl;

import com.ty.mb.zm.stu.entity.Student;
import com.ty.mb.zm.stu.mapper.StudentMapper;
import com.ty.mb.zm.stu.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 钟鸣
 * @since 2020-05-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
