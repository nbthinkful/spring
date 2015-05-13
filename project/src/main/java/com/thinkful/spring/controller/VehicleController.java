package com.thinkful.spring.controller;

import com.google.common.base.Preconditions;
import com.thinkful.contract.dto.VehicleDto;
import com.thinkful.contract.dto.VehicleModelDto;
import com.thinkful.contract.dto.VehiclePersistenceRequest;
import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleModel;
import com.thinkful.spring.mapper.DtoMapper;
import com.thinkful.spring.service.VehicleModelService;
import com.thinkful.spring.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleModelService vehicleModelService;

    @Autowired
    DtoMapper mapper;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public HttpEntity<List<VehicleDto>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();
        List<VehicleDto> vehicleDtos = mapper.mapAsList(vehicles,VehicleDto.class);

        return new ResponseEntity<List<VehicleDto>>(vehicleDtos, HttpStatus.OK);
    }

    @RequestMapping(value="/vehicle", method = RequestMethod.POST)
    public HttpEntity<VehicleDto> createVehicle(@RequestBody VehiclePersistenceRequest vehiclePersistenceRequest) {
        Preconditions.checkArgument(vehiclePersistenceRequest != null);

        VehicleModel vehicleModelEntity = vehicleModelService.findById(vehiclePersistenceRequest.getModelId());
        Preconditions.checkArgument(vehicleModelEntity != null, "No matching vehicle model found");

        Vehicle vehicleEntity = vehicleService.createVehicle(vehicleModelEntity, vehiclePersistenceRequest.getColor());
        VehicleDto vehicleDto = mapper.map(vehicleEntity, VehicleDto.class);

        return new ResponseEntity<VehicleDto>(vehicleDto,HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicle-models",method = RequestMethod.GET)
    public HttpEntity<List<VehicleModelDto>> getAllVehicleModels() {

        List<VehicleModel> vehicleModels = vehicleModelService.findAllVehicleModels();

        List<VehicleModelDto> vehicleModelDtos = mapper.mapAsList(vehicleModels,VehicleModelDto.class);

        return new ResponseEntity<List<VehicleModelDto>>(vehicleModelDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/vehicle-model",method = RequestMethod.POST)
    public HttpEntity<VehicleModelDto> createVehicleModel(@RequestBody VehicleModelDto vehicleModelRequest) {
        Preconditions.checkArgument(vehicleModelRequest != null);

        VehicleModel vehicleModelEntity = vehicleModelService.createVehicleModel(vehicleModelRequest.getName());
        VehicleModelDto vehicleModelDto = mapper.map(vehicleModelEntity,VehicleModelDto.class);

        return new ResponseEntity<VehicleModelDto>(vehicleModelDto, HttpStatus.OK);
    }
}
