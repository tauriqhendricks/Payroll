package za.ac.cput.service.demography.impl;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.demography.GenderRepository;
import za.ac.cput.service.demography.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {

    private GenderRepository repository;

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(String s) {
        return repository.read(s);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }
}
