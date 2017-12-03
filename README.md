# Spring Tutorial
This branch illustrates a Spring Boot REST API that uses Spring Framework's Dependency injection integrated with Hibernate and exposed over a Rest API.

## Prerequisites:
This project requires the following to be installed: -
 - Oracle Java 8
 - Apache Maven 3+ [https://maven.apache.org/download.cgi]
 - A Postresql database is required when executing in production Mode. If docker is installed, one can create a Postresql instance by running the below command: -  
     `docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=thinkful -p 5432:5432 -d postgres`
 
## Installation:
Use the following command to build the artifact  
`mvn install`  

This will create a jar file in folder `project/target/api-1.0-SNAPSHOT.jar`  

## Testing:
Use the following command to test the artifact  
`mvn test`  

This will create reports in folder `project/target/surefire-reports`.  

## Execution:
Use the following command to execute the artifact  

Launch in default(dev) Mode: `mvn clean install exec:java`  
To Launch in Production Mode: `mvn clean install exec:java -Dspring.profiles.active=prod`    

This will Launch the API, that can now be accessed by browsing http://localhost:8080

**Note**: For demonstration purposes, hibernate auto ddl has been configured in `resources/prod/database.properties` to always recreate the schema. In a real production environment, schema can be managed independently from auto ddl.  

## Implementation Details:
This implementation build up on the ORM branch illustrated earlier. As one can observe, there is an additional project, `Contract`. This project is intended to define all Data Transfer Objects (DTOs) which define the data structures that will be defined by the REST Api, both for incoming or returning purposes. The DTOs must be simple objects that can be serialised over REST and then Deserialised back by the end client application (i.e. if it's a Java-based Client, simply add the contract as the client's dependency). 

One can observe that the Spring Configurations have now increased to support the Web and Rest configurations. The `com.thinkful.spring.controller.VehicleController` is the REST entrypoint to interact with the Vehicle-related operations. The following are the implemented endpoints: -
 - [GET] `/vehicles`: Retrieves a list of Vehicle details that are stored in the database
 - [POST] `/vehicle`: Create a new vehicle in the database
 - [PUT] `/vehicle`: Updates an existing vehicle from the database
 - [GET] `/vehicle-models`: Retrieves a list of vehicle models included in the database
 - [POST] `/vehicle-model`: Creates a new vehicle model into the database
 These operations all use the Service Layer described earlier in the ORM branch but then it uses a Object Mapper Orika to convert Entity Objects to DTOs and vice versa. Orika is configured by `com.thinkful.spring.mapper.DtoMapper`  
 
When writing tests within a web project, one must take into consideration that tests do not have a Web Context, so they execute the process in a different manner, so not all the configurations are applicable to the tests. For this reason, the `com.thinkful.spring.config.TestMainConfiguration` configuration file was implemented to replace the `MainConfiguration` and exclude unnecessary configurations that might cause problems when running tests.  

One can use Postman to interact with the API layer  

