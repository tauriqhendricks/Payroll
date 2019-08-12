package za.ac.cput.service.demography;

import za.ac.cput.domain.demography.Race;
import za.ac.cput.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
