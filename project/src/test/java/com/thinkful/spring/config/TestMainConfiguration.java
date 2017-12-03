package com.thinkful.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = "com.thinkful",excludeFilters={
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MainConfiguration.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfiguration.class)
})
@PropertySource({"classpath:application.properties"})
public class TestMainConfiguration {
}
