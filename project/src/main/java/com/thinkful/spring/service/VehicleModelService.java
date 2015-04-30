package com.thinkful.spring.service;


import com.thinkful.spring.entity.VehicleModel;

import javax.transaction.Transactional;
import java.util.List;

public interface VehicleModelService {

    VehicleModel createVehicleModel(String modelName);

    List<VehicleModel> findAllVehicleModels();

    void deleteVehicleModel(int vehicleModelId);
}
