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
`mvn exec:java`
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

