package za.ac.cput.service.people;

import za.ac.cput.domain.people.Employee;
import za.ac.cput.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
