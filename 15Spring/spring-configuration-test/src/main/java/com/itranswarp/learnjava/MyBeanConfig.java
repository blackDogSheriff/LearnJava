package com.itranswarp.learnjava;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class MyBeanConfig {
    @Bean
    public Country country() {
        return new Country();
    }

    @Bean
    public UserInfo userInfo() {
        return new UserInfo(country());
    }
}
