package za.ac.cput.repository.demography;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race> getAll();
}
