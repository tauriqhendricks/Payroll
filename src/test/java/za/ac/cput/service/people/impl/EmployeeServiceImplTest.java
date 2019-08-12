package za.ac.cput.service.people.impl;

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
import za.ac.cput.repository.people.impl.EmployeeRepositoryImpl;

import java.util.Set;

public class EmployeeServiceImplTest {

    private EmployeeRepository repository;
    private Employee employee;
    private Gender gender;
    private Race race;

    private Employee getSaved(){
        return this.repository.getAll().iterator().next();
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
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void b_read() {
        a_create();
        Employee saved = getSaved();
        Employee read = this.repository.read(saved.getEmployeeId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_update() {
        String  newLastName = "Hendricks";
        Employee updated = new Employee.Builder().copy(getSaved()).lastName(newLastName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLastName, updated.getLastName());
    }

    @Test
    public void c_getAll() {
        Set<Employee> employees = this.repository.getAll();
        System.out.println("In getall, all = " + employees);
    }

    @Test
    public void e_delete() {
        Employee saved = getSaved();
        this.repository.delete(saved.getEmployeeId());
        c_getAll();
    }
}