package za.ac.cput.factory.people;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.domain.people.Employee;
import za.ac.cput.factory.demography.GenderFactory;
import za.ac.cput.factory.demography.RaceFactory;

public class EmployeeFactoryTest {

    private String employeeId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Race race;

    @Before
    public void buildGender(){
        this.gender = GenderFactory.buildGender("1","male");
    }

    @Before
    public void buildRace(){
        this.race = RaceFactory.buildRace("1","black");
    }

    @Before
    public void setUp() throws Exception {
        this.employeeId = "1";
        this.firstName = "John";
        this.lastName = "Doe";
    }

    @Test
    public void buildEmployee() {
        Employee employee = EmployeeFactory.buildEmployee(employeeId, firstName, lastName, gender, race);
        Assert.assertNotNull(employee.getEmployeeId());
        Assert.assertNotNull(employee);
        System.out.println(employee.toString());
    }
}