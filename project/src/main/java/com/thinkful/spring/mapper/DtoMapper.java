package com.thinkful.spring.mapper;

import com.thinkful.contract.dto.VehicleDto;
import com.thinkful.contract.dto.VehicleModelDto;
import com.thinkful.spring.entity.Vehicle;
import com.thinkful.spring.entity.VehicleModel;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(
                factory.classMap(VehicleModel.class, VehicleModelDto.class)
                        .fieldMap("id", "id").add()
                        .byDefault()
                        .toClassMap());

        factory.registerClassMap(
                factory.classMap(Vehicle.class, VehicleDto.class)
                        .byDefault()
                        .toClassMap());
    }
}
