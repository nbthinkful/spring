package com.thinkful.spring.service.impl;

import com.thinkful.spring.service.ProcessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
//The prod profile can be triggered by adding
//-Dspring.profiles.active="prod"
//to the vm options when launching the Runner class
public class ProductionProcessService implements ProcessService {

    @Override
    public void performOperation() {
        System.out.println("I am the PRODUCTION PROCESS SERVICE");
    }
}
