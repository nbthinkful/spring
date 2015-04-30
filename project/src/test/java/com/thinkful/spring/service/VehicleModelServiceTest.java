package com.thinkful.spring.service;


import com.thinkful.spring.Process;
import com.thinkful.spring.config.MainConfiguration;
import com.thinkful.spring.config.Profiles;
import com.thinkful.spring.entity.VehicleModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {MainConfiguration.class})
@ActiveProfiles(profiles = Profiles.DEFAULT)
public class VehicleModelServiceTest {

    @Autowired
    VehicleModelService vehicleModelService;

    @Test(expected = IllegalArgumentException.class)
    public void testVehicleModelCreateErrorNullModel() {
        vehicleModelService.createVehicleModel(null);
    }

    @Test
    public void testVehicleModelCreation() {
        VehicleModel model = vehicleModelService.createVehicleModel("model 1");
        Assert.assertNotNull(model);
        Assert.assertTrue("The primary key was not properly assigned", model.getId() > 0);
        Assert.assertEquals("model 1", model.getName());

        vehicleModelService.deleteVehicleModel(model.getId());
    }

    @Test
    public void testVehicleModelUpdate() {
        VehicleModel model = vehicleModelService.createVehicleModel("model");
        model.setName("updated");

        model = vehicleModelService.updateVehicleModel(model);
        Assert.assertEquals("updated",model.getName());

        vehicleModelService.deleteVehicleModel(model.getId());
    }

    @Test
    public void testVehicleModelFinding() {
        //Step 1... Checking that there are no vehicle models in the database
        List<VehicleModel> allModels = vehicleModelService.findAllVehicleModels();
        Assert.assertNotNull(allModels);
        Assert.assertTrue(allModels.size() == 0);

        //Step 2... Creating 10 vehicle models.
        int vecicleModelCreationCount = 10;
        for (int i=0; i<vecicleModelCreationCount; i++) {
            vehicleModelService.createVehicleModel("Model #" + i);
        }

        //Step 3... Checking that there are 10 vehicle models in the database
        allModels = vehicleModelService.findAllVehicleModels();
        Assert.assertNotNull(allModels);
        Assert.assertTrue(allModels.size() == vecicleModelCreationCount);

        //Step 4... Deleting all vehicle models that were created
        for (VehicleModel model: allModels) {
            vehicleModelService.deleteVehicleModel(model.getId());
        }

        //Step 5... Checking that the vehicle models have all been deleted
        allModels = vehicleModelService.findAllVehicleModels();
        Assert.assertNotNull(allModels);
        Assert.assertTrue(allModels.size() == 0);
    }
}
