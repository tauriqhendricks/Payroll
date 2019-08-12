package za.ac.cput.service.demography.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.factory.demography.RaceFactory;
import za.ac.cput.repository.demography.RaceRepository;
import za.ac.cput.repository.demography.impl.RaceRepositoryImpl;

import java.util.Set;

import static org.junit.Assert.*;

public class RaceServiceImplTest {

    private RaceRepository repository;
    private Race race;

    private Race getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.buildRace("1","black");
    }

    @Test
    public void a_create() {
        Race created = this.repository.create(this.race);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.race);
    }

    @Test
    public void b_read() {
        a_create();
        Race saved = getSaved();
        Race read = this.repository.read(saved.getRaceId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_update() {
        String  updateString = "white";
        Race updated = new Race.Builder().copy(getSaved()).race(updateString).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(updateString, updated.getRace());
    }

    @Test
    public void c_getAll() {
        Set<Race> races = this.repository.getAll();
        System.out.println("In getall, all = " + races);
    }

    @Test
    public void e_delete() {
        Race saved = getSaved();
        this.repository.delete(saved.getRaceId());
        c_getAll();
    }
}