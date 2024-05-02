package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Employee {
    @Id
    private String employeeId;
    private String name;
    private String surname;
    private int age;

    protected Employee() {
        // can only be accessed within its own class, subclasses and classes within the same package
    }

    // Takes the values set by the Builder class and assigns it to the values in Employee
    // Ensures that an Employee object is created with the correct data
    public Employee(Builder builder) {
        this.employeeId = builder.employeeId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
    }

    // insert getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getAge() == employee.getAge() && Objects.equals(getEmployeeId(), employee.getEmployeeId()) && Objects.equals(getName(), employee.getName()) && Objects.equals(getSurname(), employee.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getName(), getSurname(), getAge());
    }

    @Override
    public String toString() {
        return "Employee" + "\n-----------------\n" +
                "Employee ID = " + "#" + employeeId + "\n" +
                "Name = " + name + "\n" +
                "Surname = " + surname + "\n" +
                "Age = " + age + "\n";
    }

    // Builder class
    public static class Builder {
        @Id
        private String employeeId;
        private String name;
        private String surname;
        private int age;

        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        /* Making an Employee object in the builder
           This method creates a copy of all the attributes in the Employee class */
        public Builder copy(Employee obj) {
            this.employeeId = obj.employeeId;
            this.name = obj.name;
            this.surname = obj.surname;
            this.age = obj.age;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
