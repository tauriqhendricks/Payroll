package za.ac.cput.repository.demography.impl;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.demography.GenderRepository;

import java.util.*;

public class GenderRepositoryImpl implements GenderRepository {

    private static GenderRepositoryImpl repository = null;
    private Map<String, Gender> genders;

    private GenderRepositoryImpl() {
        this.genders = new HashMap<>();
    }

    public static GenderRepository getRepository() {
        if (repository == null) repository = new GenderRepositoryImpl();
        return repository;
    }

    public Gender create(Gender gender) {
        this.genders.put(gender.getGenderId(), gender);
        return gender;
    }

    public Gender read(String genderId) {
        return this.genders.get(genderId);
    }

    public Gender update(Gender gender) {
        this.genders.replace(gender.getGenderId(), gender);
        return this.genders.get(gender.getGenderId());
    }

    public void delete(String genderId) {
        this.genders.remove(genderId);
    }

    public Set<Gender> getAll() {
        Collection<Gender> genders = this.genders.values();
        Set<Gender> set = new HashSet<>();
        set.addAll(genders);
        return set;
    }
}