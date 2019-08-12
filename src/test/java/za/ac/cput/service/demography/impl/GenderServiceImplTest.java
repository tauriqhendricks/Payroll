package za.ac.cput.service.demography.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.factory.demography.GenderFactory;
import za.ac.cput.repository.demography.GenderRepository;
import za.ac.cput.repository.demography.impl.GenderRepositoryImpl;

import java.util.Set;

import static org.junit.Assert.*;

public class GenderServiceImplTest {

    private GenderRepository repository;
    private Gender gender;

    private Gender getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getRepository();
        this.gender = GenderFactory.buildGender("1","male");
    }

    @Test
    public void a_create() {
        Gender created = this.repository.create(this.gender);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.gender);
    }

    @Test
    public void b_read() {
        a_create();
        Gender saved = getSaved();
        Gender read = this.repository.read(saved.getGenderId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_update() {
        String  updateString = "female";
        Gender updated = new Gender.Builder().copy(getSaved()).gender(updateString).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(updateString, updated.getGender());
    }

    @Test
    public void c_getAll() {
        Set<Gender> genders = this.repository.getAll();
        System.out.println("In getall, all = " + genders);
    }

    @Test
    public void e_delete() {
        Gender saved = getSaved();
        this.repository.delete(saved.getGenderId());
        c_getAll();
    }
}