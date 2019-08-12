package za.ac.cput.repository.people.impl;

import za.ac.cput.domain.people.Employee;
import za.ac.cput.repository.people.EmployeeRepository;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Map<String, Employee> employees;

    private EmployeeRepositoryImpl() {
        this.employees = new HashMap<>();
    }

    public static EmployeeRepository getRepository() {
        if (repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee) {
        this.employees.put(employee.getEmployeeId(), employee);
        return employee;
    }

    public Employee read(String employeeId) {
        return this.employees.get(employeeId);
    }

    public Employee update(Employee employee) {
        this.employees.replace(employee.getEmployeeId(), employee);
        return this.employees.get(employee.getEmployeeId());
    }

    public void delete(String employeeId) {
        this.employees.remove(employeeId);
    }

    public Set<Employee> getAll() {
        Collection<Employee> employees = this.employees.values();
        Set<Employee> set = new HashSet<>();
        set.addAll(employees);
        return set;
    }
}
