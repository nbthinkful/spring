package com.thinkful.spring;


import com.thinkful.spring.config.MainConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {MainConfiguration.class})
@ActiveProfiles(profiles = "default")
public class ProcessTest {

    @Autowired
    Process process;

    @Test
    public void testMalePersonIsPrototypeScope() {
        Assert.assertNotNull(process.male);
        Assert.assertNotNull(process.anotherMale);

        String originalName = process.male.getName();
        Assert.assertEquals(process.male.getName(),"John");
        process.male.setName("NONAMEATALL");
        Assert.assertEquals(process.male.getName(), "NONAMEATALL");

        Assert.assertNotEquals(process.anotherMale.getName(),"NONAMEATALL");
        process.male.setName(originalName);
    }
}
