package com.itranswarp.learnjava;

import java.time.ZoneId;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.itranswarp.learnjava.service.UserService;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy // 自动查找@Aspect 的Bean，然后根据每个方法的@Before @Around等注解，把AOP注入到特定的Bean中
public class AppConfig {

    @Bean
    ZoneId creatZoneId() {
        return ZoneId.of("Z");
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.register("test@example.com", "password", "test");
        userService.login("bob@example.com", "password");
        // UserService class name: UserService$$SpringCGLIB$$0:
        System.out.println(userService.getClass().getName());
        System.out.println("Hello world!");
    }

}