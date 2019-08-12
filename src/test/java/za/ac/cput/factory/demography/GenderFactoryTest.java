package za.ac.cput.factory.demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Gender;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    private String genderId;
    private String gender;

    @Before
    public void setUp() throws Exception {
        this.genderId = "1";
        this.gender = "male";
    }

    @Test
    public void buildEmployee() {
        Gender gen = GenderFactory.buildGender(genderId, gender);
        Assert.assertNotNull(gen.getGenderId());
        Assert.assertNotNull(gen);
        System.out.println(gen.toString());
    }
}