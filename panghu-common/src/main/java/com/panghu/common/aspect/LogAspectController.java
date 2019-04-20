package com.panghu.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Order(1)
@Slf4j
public class LogAspectController {

    //接口消费时间
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.panghu.*.controller.*.*(..))")
    private void controllerAspect() {
    }

    //在方法执行前打印请求内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());//当前时间
        //获取本次请求的Request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============================请求内容====================================");
        try {
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        } catch (Exception e) {
            log.error("###LogAspectController.class methodBefore() ### ERROR:", e);
        }
        log.info("===============================请求内容====================================");
    }

    // 在方法执行完结后打印响应内容
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturning(Object o) {
        //处理完请求，返回内容
        log.info("===============================响应内容====================================");
        try {
            log.info("SPEND TIME :{}", (System.currentTimeMillis() - startTime.get()));

        } catch (Exception e) {
            log.error("###LogAspectController.class methodAfterReturing() ### ERROR:{}", e, e);
        }
        log.info("===============================响应内容====================================");
    }

}
