package za.ac.cput.service.demography;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String>{
    Set<Gender> getAll();
}