package com.thinkful.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.thinkful")
@PropertySource({"classpath:application.properties"})
public class MainConfiguration {
}
