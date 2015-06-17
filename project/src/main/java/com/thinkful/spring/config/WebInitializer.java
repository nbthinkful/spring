package com.thinkful.spring.config;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

//This class will not be invoked when running the web application from Spring Boot
//however it is needed when deploying on a tomcat (without spring boot involved)
//so I added it to the project for reference purposes.
public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MainConfiguration.class);
        ctx.setServletContext(servletContext);

        servletContext.addFilter("Spring OpenSessionInViewFilter", new OpenSessionInViewFilter());

        //Define the default profile
        servletContext.setInitParameter("spring.profiles.default", Profiles.PRODUCTION);

        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
