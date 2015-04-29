package com.thinkful.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@Profile(Profiles.PRODUCTION)
@Configuration
@PropertySource({"classpath:prod/database.properties"})
public class ProdConfiguration {

    @Value("${datasource.driver}")
    String datasourceDriver;

    @Value("${datasource.uri}")
    String datasourceUri;

    @Value("${datasource.username:}")
    String datasourceUsername;

    @Value("${datasource.password:}")
    String datasourcePassword;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(datasourceDriver);
        dataSource.setUrl(datasourceUri);
        if ((datasourceUsername != null) && (datasourceUsername.length()>0)) {
            dataSource.setUsername(datasourceUsername);
            dataSource.setPassword(datasourcePassword);
        }

        return dataSource;
    }
}
