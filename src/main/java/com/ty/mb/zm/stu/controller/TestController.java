package com.ty.mb.zm.stu.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


/**
 * @program: stu
 * @description: 测试前端控制器
 * @author: zhongming
 * @time: 2020/6/3 9:59
 */
@RestController
@RequestMapping("/test")
@ApiModel("测试前端控制器")
public class TestController {
    @ApiOperation(value = "获取hostname",tags = "测试前端控制器")
    @GetMapping("/host")
    public Map host(){
        Map<String,String> map=new HashMap<>();
        try {
            map.put(InetAddress.getLocalHost().getHostName(),InetAddress.getLocalHost().getHostAddress());
            map.put(Inet4Address.getLocalHost().getHostName(),Inet4Address.getLocalHost().getHostAddress());
            map.put(Inet6Address.getLocalHost().getHostName(), Inet6Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return map;
    }
}
