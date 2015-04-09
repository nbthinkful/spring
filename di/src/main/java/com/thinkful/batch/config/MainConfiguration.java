package com.thinkful.batch.config;

import com.thinkful.batch.model.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.thinkful")
@PropertySource({"classpath:application.properties"})
public class MainConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person male() {
        Person malePerson = new Person();
        malePerson.setName("John");
        malePerson.setSurname("Doe");
        malePerson.setAge(20);

        return malePerson;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Person female() {
        Person femalePerson = new Person();
        femalePerson.setName("Jane");
        femalePerson.setSurname("Doe");
        femalePerson.setAge(18);

        return femalePerson;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
