package com.itranswarp.learnjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        // MyBeanConfig myBeanConfig = context.getBean(MyBeanConfig.class);
        return;
    }

    @Autowired
    public void equals(Country country, UserInfo userInfo) {
        System.out.println(country == userInfo.getCountry() ? "同一个对象" : "不同对象");
    }

}