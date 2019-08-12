package za.ac.cput.repository.demography.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.factory.demography.GenderFactory;
import za.ac.cput.repository.demography.GenderRepository;

import java.util.Set;

import static org.junit.Assert.*;

public class GenderRepositoryImplTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSaved() {
        Set<Gender> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.buildGender("1","male");
    }

    @Test
    public void a_create() {
        Gender genderInfo = this.repository.create(this.gender);
        c_getAll();
        Assert.assertSame(genderInfo, this.gender);
    }

    @Test
    public void b_read() {
        a_create();
        Gender saved = getSaved();
        Gender read = this.repository.read(saved.getGenderId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        c_getAll();
    }

    @Test
    public void d_update() {
        String updateString = "female";
        Gender gender = new Gender.Builder().copy(getSaved()).gender(updateString).build();
        System.out.println("In update, about_to_updated = " + gender);
        Gender updated = this.repository.update(gender);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getGender());
        c_getAll();
    }

    @Test
    public void e_delete() {
        Gender saved = getSaved();
        c_getAll();
        this.repository.delete(saved.getGenderId());
        c_getAll();
        Set<Gender> genders = this.repository.getAll();
        Assert.assertEquals(0, genders.size());
    }

    @Test
    public void c_getAll() {
        Set<Gender> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, genders.size());
    }
}