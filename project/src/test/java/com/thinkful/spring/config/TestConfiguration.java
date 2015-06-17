package com.thinkful.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.thinkful", excludeFilters = {
        @ComponentScan.Filter( type = FilterType.ASSIGNABLE_TYPE, value = { MainConfiguration.class, WebConfiguration.class} )
})
@PropertySource({"classpath:application.properties"})
public class TestConfiguration {

}
