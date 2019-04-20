package com.panghu.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextUtil.applicationContext == null) {
            SpringContextUtil.applicationContext = applicationContext;
        }

    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据Bean名称获取Bean
     *
     * @param name Bean名称
     * @return Bean
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }


    /**
     * 根据Bean字节码对象获取Bean
     *
     * @param clazz Bean字节码对象
     * @return Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }
}
