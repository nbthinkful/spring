package com.thinkful.spring;

import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleModel;
import com.thinkful.spring.service.VehicleModelService;
import com.thinkful.spring.service.VehicleService;
import com.thinkful.spring.utils.SchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Process {

    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    VehicleService vehicleService;

    public void execute() {
        try {
            System.out.println("Started Process Execution");
            generateDDL();

            VehicleModel model = vehicleModelService.createVehicleModel("hilux");

            System.out.println("Model: " + model.toString());
            System.out.println("\r\n------------------------------------------\r\n");

            VehicleModel anotherModel = vehicleModelService.createVehicleModel("another");
            System.out.println("Model: " + anotherModel.toString());
            System.out.println("\r\n------------------------------------------\r\n");

            Vehicle vehicle = vehicleService.createVehicle(model, "Red");
            System.out.println("Vehicle: " + vehicle.toString());
            System.out.println("\r\n------------------------------------------\r\n");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void generateDDL() throws Exception {
        SchemaGenerator gen = new SchemaGenerator("com.thinkful.spring.entity");
        gen.generate(SchemaGenerator.Dialect.POSTGRESQL,"/tmp/");
    }
}
