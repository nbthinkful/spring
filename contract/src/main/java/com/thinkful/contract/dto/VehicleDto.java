package com.thinkful.contract.dto;

import lombok.Data;

@Data
public class VehicleDto {
    private Long id;
    private VehicleModelDto model;
    private String color;
}
