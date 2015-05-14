package com.thinkful.spring.service.impl;

import com.google.common.base.Preconditions;
import com.thinkful.spring.dao.VehicleDao;
import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleModel;
import com.thinkful.spring.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDao vehicleDao;

    @Override
    @Transactional
    public Vehicle createVehicle(VehicleModel model, String color) {
        Preconditions.checkArgument(model != null, "Model cannot be null");
        Preconditions.checkArgument(color != null, "Color cannot be null");

        Vehicle vehicle = new Vehicle();
        vehicle.setModel(model);
        vehicle.setColor(color);

        vehicleDao.create(vehicle);
        return vehicle;
    }

    @Override
    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle) {
        Preconditions.checkArgument(vehicle != null, "Vehicle should not be null");

        return vehicleDao.update(vehicle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findVehicleById(long id) {
        return vehicleDao.findById(id);
    }

    @Override
    @Transactional
    public void deleteVehicle(long vehicleId) {
        vehicleDao.deleteById(vehicleId);
    }
}
