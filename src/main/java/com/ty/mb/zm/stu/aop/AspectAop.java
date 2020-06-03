package com.ty.mb.zm.stu.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AspectAop {
    private static Logger log = LoggerFactory.getLogger(AspectAop.class);

    @Pointcut("execution (* com.ty.mb.zm.stu.controller..*.*(..))")
    public void logaop() {
    }

    @Around("logaop()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            log.info("================================进入方法==================================");
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

            Method method = methodSignature.getMethod();
            log.info("类名称-->{}", JSONObject.toJSONString(method.getDeclaringClass().getCanonicalName()));
            Object[] args = pjp.getArgs();
            String[] params = methodSignature.getParameterNames();
            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < params.length; i++) {
                map.put(params[i], args[i]);
            }
            log.info("方法名称-->{}", JSONObject.toJSONString(method.getName()));
            log.info("方法入参-->{}", JSONObject.toJSONString(map));
            result = pjp.proceed(args);
            log.info("方法返回-->{}", JSONObject.toJSONString(result));
            long end = System.currentTimeMillis();
            log.info("耗时：-->{}ms", end - start);
        } catch (Throwable e) {
            log.debug("================================出现异常==================================");
            log.debug(e.getMessage());
        }
        return result;
    }
}
