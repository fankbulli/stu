package com.ty.mb.zm.stu.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.*;
import java.util.Enumeration;
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
    public String host(){
        String hostIP="";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration<InetAddress> nias = ni.getInetAddresses();
                while (nias.hasMoreElements()) {
                    InetAddress ia = (InetAddress) nias.nextElement();
                    if (!ia.isLinkLocalAddress() && !ia.isLoopbackAddress() && ia instanceof Inet4Address) {
                        hostIP=ia.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return hostIP;
    }
}
