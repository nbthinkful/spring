package com.thinkful.spring.dao.impl;

import com.thinkful.spring.dao.VehicleModelDao;
import com.thinkful.spring.entity.VehicleModel;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleModelDaoImpl extends AbstractCrudDao<VehicleModel, Integer> implements VehicleModelDao {
}
