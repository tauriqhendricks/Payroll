package za.ac.cput.domain.people;

import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Race race;

    private Employee(){}

    private Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.race = builder.race;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Race getRace() {
        return race;
    }

    public static class Builder {
        private String employeeId;
        private String firstName;
        private String lastName;
        private Gender gender;
        private Race race;

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder race(Race race) {
            this.race = race;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.gender = employee.gender;
            this.race = employee.race;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender.getGender() +
                ", race=" + race.getRace() +
                '}';
    }
}
