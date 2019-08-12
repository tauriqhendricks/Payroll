package za.ac.cput.factory.demography;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Race;

public class RaceFactoryTest {

    private String raceId;
    private String race;

    @Before
    public void setUp() throws Exception {
        this.raceId = "1";
        this.race = "black";
    }

    @Test
    public void buildEmployee() {
        Race r = RaceFactory.buildRace(raceId, race);
        Assert.assertNotNull(r.getRaceId());
        Assert.assertNotNull(r);
        System.out.println(r.toString());
    }
}