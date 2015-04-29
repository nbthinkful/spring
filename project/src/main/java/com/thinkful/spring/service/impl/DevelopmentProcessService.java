package com.thinkful.spring.service.impl;

import com.thinkful.spring.service.ProcessService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class DevelopmentProcessService implements ProcessService {

    @Override
    public void performOperation() {
        System.out.println("I am the DEVELOPMENT PROCESS SERVICE");
    }
}
