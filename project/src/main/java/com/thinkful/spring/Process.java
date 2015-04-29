package com.thinkful.spring;

import com.thinkful.spring.model.Person;
import com.thinkful.spring.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Process {

    @Autowired
    @Qualifier("male")
    Person male;

    @Autowired
    @Qualifier("male")
    Person anotherMale;

    @Autowired
    @Qualifier("female")
    Person female;

    @Autowired
    ProcessService processService;

    @Value("${application.name}")
    String applicationName;

    public void execute() {
        System.out.println("Started Process Execution");
        System.out.println(applicationName);

        System.out.println("MALE: " + male.toString());
        System.out.println("\r\n------------------------------------------\r\n");
        System.out.println("FEMALE: " + female.toString());
        System.out.println("\r\n------------------------------------------\r\n");

        System.out.println("Running the process service:");
        processService.performOperation();
        System.out.println("\r\n------------------------------------------\r\n");
    }
}
