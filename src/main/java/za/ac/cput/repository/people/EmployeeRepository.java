package za.ac.cput.repository.people;

import za.ac.cput.domain.people.Employee;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
