package com.gaussic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanLister
 * @Description TODO
 * @Author huangpengbing
 * @Date 2024/8/28 2:35
 * @Version 1.0
 **/


@Component
public class BeanLister {

    private final ApplicationContext context;

    @Autowired
    public BeanLister(ApplicationContext context) {
        this.context = context;
    }

    public void listBeans() {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("HPB" + beanName + ": " + bean.getClass().getName());
        }
    }
}
