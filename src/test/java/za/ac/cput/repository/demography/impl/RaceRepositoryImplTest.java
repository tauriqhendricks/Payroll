package za.ac.cput.repository.demography.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.factory.demography.RaceFactory;
import za.ac.cput.repository.demography.RaceRepository;

import java.util.Set;

import static org.junit.Assert.*;

public class RaceRepositoryImplTest {
    private RaceRepository repository;
    private Race race;

    private Race getSaved() {
        Set<Race> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.buildRace("1","black");
    }

    @Test
    public void a_create() {
        Race raceInfo = this.repository.create(this.race);
        c_getAll();
        Assert.assertSame(raceInfo, this.race);
    }

    @Test
    public void b_read() {
        a_create();
        Race saved = getSaved();
        Race read = this.repository.read(saved.getRaceId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        c_getAll();
    }

    @Test
    public void d_update() {
        String updateString = "white";
        Race race = new Race.Builder().copy(getSaved()).race(updateString).build();
        System.out.println("In update, about_to_updated = " + race);
        Race updated = this.repository.update(race);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getRace());
        c_getAll();
    }

    @Test
    public void e_delete() {
        Race saved = getSaved();
        c_getAll();
        this.repository.delete(saved.getRaceId());
        c_getAll();
        Set<Race> races = this.repository.getAll();
        Assert.assertEquals(0, races.size());
    }

    @Test
    public void c_getAll() {
        Set<Race> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, races.size());
    }
}