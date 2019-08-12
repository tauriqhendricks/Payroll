package za.ac.cput.factory.demography;

import za.ac.cput.domain.demography.Gender;

public class GenderFactory {
    public static Gender buildGender(String genderId, String gender){
        return new Gender.Builder()
                .genderId(genderId)
                .gender(gender)
                .build();
    }
}