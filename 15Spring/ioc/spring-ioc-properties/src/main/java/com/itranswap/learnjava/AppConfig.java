package com.itranswap.learnjava;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.itranswap.learnjava.service.UserService;

@Configuration
@ComponentScan
@PropertySource("app.properties")
@PropertySource("smtp.properties")
public class AppConfig {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("bob@example.com", "password");
    }

    @Bean
    ZoneId creatZoneId(@Value("${app.zone:Z}") String zoneId) {

        return ZoneId.of(zoneId);
    }

}
