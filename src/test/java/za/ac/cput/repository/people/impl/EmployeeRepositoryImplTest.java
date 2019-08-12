package za.ac.cput.repository.people.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.domain.people.Employee;
import za.ac.cput.factory.demography.GenderFactory;
import za.ac.cput.factory.demography.RaceFactory;
import za.ac.cput.factory.people.EmployeeFactory;
import za.ac.cput.repository.people.EmployeeRepository;

import java.util.Set;

public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee employee;
    private Gender gender;
    private Race race;

    private Employee getSavedEmployee() {
        Set<Employee> savedEmployees = this.repository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.gender = GenderFactory.buildGender("1","male");
        this.race = RaceFactory.buildRace("1","black");
        this.employee = EmployeeFactory.buildEmployee("1","John","Doe", this.gender, this.race);
    }

    @Test
    public void a_create() {
        Employee employeeInfo = this.repository.create(this.employee);
        c_getAll();
        Assert.assertSame(employeeInfo, this.employee);
    }

    @Test
    public void b_read() {
        a_create();
        Employee savedEmployee = getSavedEmployee();
        Employee read = this.repository.read(savedEmployee.getEmployeeId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(savedEmployee, read);
        c_getAll();
    }

    @Test
    public void d_update() {
        String updateString = "Hendricks";
        Employee employee = new Employee.Builder().copy(getSavedEmployee()).lastName(updateString).build();
        System.out.println("In update, about_to_updated = " + employee);
        Employee updated = this.repository.update(employee);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getLastName());
        c_getAll();
    }

    @Test
    public void e_delete() {
        Employee savedEmployee = getSavedEmployee();
        c_getAll();
        this.repository.delete(savedEmployee.getEmployeeId());
        c_getAll();
        Set<Employee> employees = this.repository.getAll();
        Assert.assertEquals(0, employees.size());
    }

    @Test
    public void c_getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, employees.size());
    }
}