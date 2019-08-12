package za.ac.cput.repository.demography.impl;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.demography.RaceRepository;

import java.util.*;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl repository = null;
    private Map<String, Race> races;

    private RaceRepositoryImpl() {
        this.races = new HashMap<>();
    }

    public static RaceRepository getRepository() {
        if (repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    public Race create(Race race) {
        this.races.put(race.getRaceId(), race);
        return race;
    }

    public Race read(String raceId) {
        return this.races.get(raceId);
    }

    public Race update(Race race) {
        this.races.replace(race.getRaceId(), race);
        return this.races.get(race.getRaceId());
    }

    public void delete(String raceId) {
        this.races.remove(raceId);
    }

    public Set<Race> getAll() {
        Collection<Race> races = this.races.values();
        Set<Race> set = new HashSet<>();
        set.addAll(races);
        return set;
    }
}