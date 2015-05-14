package com.thinkful.contract.dto;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class VehicleDto {
    private Long id;
    private VehicleModelDto model;
    private String color;
    private DateTime date = DateTime.now();
}
