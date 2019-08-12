package za.ac.cput.factory.people;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.domain.people.Employee;

public class EmployeeFactory {
    public static Employee buildEmployee(String employeeId, String firstName, String lastName, Gender gender, Race race){
        return new Employee.Builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .race(race)
                .build();
    }
}
