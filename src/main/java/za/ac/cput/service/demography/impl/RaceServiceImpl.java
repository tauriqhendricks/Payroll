package za.ac.cput.service.demography.impl;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.demography.RaceRepository;
import za.ac.cput.service.demography.RaceService;

import java.util.Set;

public class RaceServiceImpl implements RaceService {

    private RaceRepository repository;

    @Override
    public Race create(Race race) {
        return repository.create(race);
    }

    @Override
    public Race read(String s) {
        return repository.read(s);
    }

    @Override
    public Race update(Race race) {
        return repository.update(race);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<Race> getAll() {
        return repository.getAll();
    }
}
