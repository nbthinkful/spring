# Spring Tutorial
This branch illustrates a console application that uses Spring Framework's Dependency injection integrated with Hibernate that can store data into a postresql database

## Prerequisites:
This project requires the following to be installed: -
 - Oracle Java 8
 - Apache Maven 3+ [https://maven.apache.org/download.cgi]
 - A Postresql database is required when executing in production Mode. If docker is installed, one can create a Postresql instance by running the below command: -  
     `docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=thinkful -p 5432:5432 -d postgres`
 
## Installation:
Use the following command to build the artifact  
`mvn install`  

This will create a jar file in folder `project/target/orm-1.0-SNAPSHOT.jar`  

## Testing:
Use the following command to test the artifact  
`mvn test`  

This will create reports in folder `project/target/surefire-reports`.  

## Execution:
Use the following command to execute the artifact  

Launch in default(dev) Mode: `mvn exec:java`  
To Launch in Production Mode: `mvn exec:java -Dspring.profiles.active=prod`    

This will execute the artifact and produce the following output: -  
```
alter table VEHICLE 
        drop constraint FK_6rgxky3uyfnexhb4qufs383h2;

    drop table if exists VEHICLE cascade;

    drop table if exists VEHICLEMODEL cascade;

    drop sequence hibernate_sequence;

    create table VEHICLE (
        id int8 not null,
        color varchar(255) not null,
        vehiclemodel_id int4,
        primary key (id)
    );

    create table VEHICLEMODEL (
        id int4 not null,
        name varchar(255) not null,
        primary key (id)
    );

    alter table VEHICLE 
        add constraint FK_6rgxky3uyfnexhb4qufs383h2 
        foreign key (vehiclemodel_id) 
        references VEHICLEMODEL;

    create sequence hibernate_sequence;
2017-12-03 17:13:05.573  INFO 30988 --- [g.Runner.main()] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000230: Schema export complete
Model: VehicleModel(id=10, name=hilux)

------------------------------------------

Model: VehicleModel(id=11, name=another)

------------------------------------------

Vehicle: Vehicle(id=20, model=VehicleModel(id=10, name=hilux), color=Red)

------------------------------------------
```
**Note**: For demonstration purposes, hibernate auto ddl has been configured in `resources/prod/database.properties` to always recreate the schema. In a real production environment, schema can be managed independently from auto ddl.  

As a result from executing the application, 2 database tables will be created in a PostreSql database (db name `thinkful`) and 2 rows will be added to the `vehiclemodel` table and 1 row added to the `vehicle` table.

## Implementation Details:
This implementation build upon the DI implementation provided earlier. The `com.thinkful.spring.Runner` is still the entry point of the application, but this time, there are 2 distinct configurations for `Production` / `Development` (default) mode, where the production configuration configures hibernate to connect to a PostreSQL database, while in development mode, the system uses an embedded HSQL Db Database that is to be used primarily for integration testing. Hibernate totally abstracts the database layer so connecting to a PostreSQL or an embedded HSQL Db will be totally transparent **Provided That** any data lookups / creations / additions are performed via the hibernate Object Relational Mapper (ORM). 

Database Tables are directly mapped by Entity Classes `com.thinkful.spring.entity.Vehicle` and `com.thinkful.spring.entity.VehicleModel` that include annotations and descriptions of how the data is related to one another. Create / Read / Update / Delete (CRUD) Operations are provided by the `com.thinkful.spring.dao.CrudDAO` interface implemented by the Abstract Generic Class `com.thinkful.spring.dao.impl.AbstractCrudDao`. The generic implementation allows for reusability for more specific uses such as the `com.thinkful.spring.dao.VechicleDao` and the `com.thinkful.spring.dao.VehicleModelDao` interfaces, whose implementation is just connecting the Entity and the Primary key's data type as shown in the implementations `com.thinkful.spring.dao.impl.VehicleDaoImpl` and `com.thinkful.spring.dao.impl.VehicleModelDaoImpl` respectively.  The objective of Data Access Objects (DAO) is to provide the direct database connectivity of a given entity.

The Business Model is implemented by the Service Design Pattern, which as shown in the interface `com.thinkful.spring.service.VehicleService` and `com.thinkful.spring.service.VehicleModelService`, these provide another abstraction layer from the database layer which allows us to be more business implementation oriented. In a real life scenario, the service layer might require an interaction with more than one Data Access Object so Database Transactivity is defined at this layer in order to ensure that the necessary transactins are applied to the whole business logic. In a typical web application, the UI layer interacts directly with the Service layer in order to achieve a total abstraction from the data layer that the system is interacting with. Service layer can also utilise caches so that the required data can be retrieved from caches as opposed to the DAOs as necessary.  

Two test suites (`com.thinkful.spring.service.VehicleServiceTest` and `com.thinkful.spring.service.VehicleModelServiceTest`) are implemented in this example, which target to test the various operations of the respective service layer implementations. Tests are executed with the Default (Development) profile, so data is created and fetched from an embedded hsqldb. This ensures that no PostreSQL database is needed to fulfill the test, however the test is still using a database to persist the data, one that can be destroyed once the test is finished.  

