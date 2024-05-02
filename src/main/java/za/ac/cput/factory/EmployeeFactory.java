package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.utils.Helper;

public class EmployeeFactory {
    // Building an employee with an employee ID
    public static Employee buildEmployee(String employeeId, String name, String surname, int age) {
        if (Helper.isEmpty(employeeId)
                && Helper.isEmpty(name)
                && Helper.isEmpty(surname)
                && Helper.isEmpty(age)) {

            return new Employee.Builder()
                    .setEmployeeId(employeeId)
                    .setName(name)
                    .setSurname(surname)
                    .setAge(age)
                    .build();
        }
        return null;
    }

    // Building an employee WITHOUT an employee ID
    public static Employee buildEmployee(String name, String surname, int age) {
        if (Helper.isEmpty(name)
                && Helper.isEmpty(surname)
                && Helper.isEmpty(age)) {

            return new Employee.Builder()
                    .setEmployeeId(Helper.generateId())
                    .setName(name)
                    .setSurname(surname)
                    .setAge(age).build();
        }
        return null;
    }
}
