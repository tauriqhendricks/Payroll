package za.ac.cput.service.people.impl;

import za.ac.cput.domain.people.Employee;
import za.ac.cput.repository.people.EmployeeRepository;
import za.ac.cput.service.people.EmployeeService;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee read(String s) {
        return repository.read(s);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }
}
