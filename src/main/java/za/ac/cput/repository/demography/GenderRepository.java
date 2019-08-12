package za.ac.cput.repository.demography;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Set<Gender> getAll();
}
