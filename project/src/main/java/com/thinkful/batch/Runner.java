/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.thinkful.batch;

import com.thinkful.batch.config.MainConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Runner {

    public static void main(String[] args) throws Exception {

        System.out.println("Spring Dependency Injection Tutorial");

        ConfigurableApplicationContext context = SpringApplication.run(MainConfiguration.class, args);

        ConfigurableEnvironment environment = context.getEnvironment();
        String activeProfile = System.getProperty("spring.profiles.active");
        if (activeProfile != null) {
            environment.setActiveProfiles(activeProfile);
        }

        BeanFactory beanFactory = context.getBeanFactory();

        Process process = beanFactory.getBean(Process.class);

        process.execute();

        SpringApplication.exit(context, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 0;
            }
        });
    }
}
