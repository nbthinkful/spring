package com.thinkful.spring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(targetEntity = VehicleModel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiclemodel_id")
    private VehicleModel model;

    @Column(nullable = false)
    private String color;


}
