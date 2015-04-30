package com.thinkful.spring.dao.impl;

import com.thinkful.spring.dao.VehicleDao;
import com.thinkful.spring.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleDaoImpl extends AbstractCrudDao<Vehicle, Long> implements VehicleDao {
}
