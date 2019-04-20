package com.panghu.common.aspect;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.panghu.common.base.BasePageHelper;
import com.panghu.common.utils.ValidatorToolUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class PageAspectMapper {

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(* com.panghu.*.dao.*.page*(..))")
    private void mapperAspect() {
    }

    @Around("mapperAspect()")//环绕通知,可以在方法的前后对方法进行增强
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        if (null != signature) {
            log.info("***************分页切面进来了***************");
            // 分装mybatis的查询bean对应id
            Method method = ((MethodSignature) signature).getMethod();
            // 根据分页参数和分页返回对象自动封装成pageHelper对象
            if (method.getReturnType() == java.util.List.class) {
                for (Object object : joinPoint.getArgs()) {
                    if (object instanceof BasePageHelper) {
                        BasePageHelper basePageVo = (BasePageHelper) object;
                        // 页码和页面大小验证
                        if (basePageVo.getPageNum() > 0 && basePageVo.getPageSize() > 0) {
                            PageHelper.startPage(basePageVo.getPageNum(), basePageVo.getPageSize());
                        }
                        // 排序方式
                        if (ValidatorToolUtils.isNotNullOrEmpty(basePageVo.getSort())) {
                            // 排序字段处理 驼峰转为数据库对应字段
                            PageHelper.orderBy(basePageVo.getSort() + " " + (ValidatorToolUtils.isNotNullOrEmpty(basePageVo.getOrder()) ? basePageVo.getOrder() : "desc"));
                        }
                    }
                }
            }
        }
        try {
            //这一步是让目标方法执行,这也是环绕通知和前置,后置通知方法的一个最大区别
            Object result = joinPoint.proceed();
            log.info("***************分页切面结束了*************** result:{}", JSON.toJSONString(result));
            return result;
        } catch (Exception e) {
            log.error("PageAspect 异常：{}", JSON.toJSONString(e));
            throw e;
        }
    }
}
