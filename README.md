# Spring Tutorial
This branch illustrates the dependency injection features of Spring Framework. 

## Prerequisites:
This project requires the following to be installed: -
 - Oracle Java 8
 - Apache Maven 3+ [https://maven.apache.org/download.cgi]

## Installation:
Use the following command to build the artifact  
`mvn install`  

This will create a jar file in folder `project/target/di-1.0-SNAPSHOT.jar`  

## Testing:
Use the following command to test the artifact  
`mvn test`  

This will create reports in folder `project/target/surefire-reports`.  

## Execution:
Use the following command to execute the artifact  
`cd project`  
Launch in default(dev) Mode: `mvn exec:java`  

This will execute the artifact and produce the following output: -

```
Started Process Execution
Thinkful Spring Dependency Injection Tutorial
MALE: Person(name=John, surname=Doe, age=20)

------------------------------------------

FEMALE: Person(name=Jane, surname=Doe, age=18)

------------------------------------------

Running the process service:
I am the DEVELOPMENT PROCESS SERVICE

------------------------------------------
```
To Launch in Production Mode: `mvn exec:java -Dspring.profiles.active=prod`    

## Implementation Details:
The objective of this tutorial is to demonstrate the introduction of Spring Framework's Dependency Injection. The application starts by executing the `com.thinkful.spring.Runner` that uses Spring Boot to initialise the console application and provide it with the `com.thinkful.spring.config.MainConfiguration` configuration class. The configuration class is responsible of connecting all the Spring modules together, and also is loading an application.properties file that is embedded within the resources folder. For demonstration purposes, the `MainConfiguration` is returning 2 Java Beans of type `com.thinkful.spring.model.Person` in 2 different modes. If the qualifier is `male`, then it injects the instance as a Prototype, or else a new instance every time or if the qualifier is `female`, the instance is injected as a Singleton Design Pattern, meaning that only 1 instance will be available for the whole instance of the Application.  

The `com.thinkful.spring.Process` Component is then loaded and executed. The execution merely prints out the content of what's included in the injected modules, typically the male and female's name, the application name that is injected directly from the application.properties file and the processService that is injected according to the Spring Profile set up. Spring Profiles are used to determine the mode of how the application is instantiated, and the implementation provided for interface `com.thinkful.spring.service.ProcessService` varies according to whether it is launched in Development (`com.thinkful.spring.service.impl.DevelopmentProcessService`) or in Production (`com.thinkful.spring.service.impl.ProductionProcessService`). For the scope of this demo application, the performOperation() is only displaying a different message, but one can appreciate that the impact that this configuration has on an actual application is massive.

A single unit test (`com.thinkful.spring.ProcessTest`) is implemented which automatically wires all the configuration as necessary so all processes that require Dependency Injection will be satisfied by Spring Framework. It is possible to use additional Spring Configuration Classes that are only available during Testing, which are normally required to mock certain parts of the code in order to be able to execute the tests without requiring any external systems connected to them.

