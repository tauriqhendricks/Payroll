package za.ac.cput.factory.demography;

import za.ac.cput.domain.demography.Race;

public class RaceFactory {
    public static Race buildRace(String raceId, String race){
        return new Race.Builder()
                .raceId(raceId)
                .race(race)
                .build();
    }
}