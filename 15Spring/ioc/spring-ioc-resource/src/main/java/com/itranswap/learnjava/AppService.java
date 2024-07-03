package com.itranswap.learnjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AppService {
    @Value("1")
    private int version;

    @Value("classpath:/logo.txt")
    // @Value("file:/path/to/logo.txt") //也可以指定系统路径
    private Resource resource;

    private String logo;

    @PostConstruct
    public void init() throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            // this.logo = reader.lines().collect(Collectors.joining("\n"));
            this.logo = reader.lines().collect(Collectors.joining("\n"));

        }
    }

    public void printLogo() {
        System.out.println(logo);
        System.out.println("app version: " + version);
    }

}
