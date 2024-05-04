package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.IEmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository;

    // Injecting the EmployeeRepository dependency
    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee obj) {
        return employeeRepository.save(obj);
    }

    @Override
    public Employee read(String s) {
        return employeeRepository.findById(s).orElseThrow(null);
    }

    @Override
    public Employee update(Employee obj) {
        Employee e1 = read(obj.getEmployeeId()); // Check if the employee object exists to avoid conflicts
        if (e1 == null) {
            return null;
        }
        return employeeRepository.save(e1);
    }

    @Override
    public boolean delete(String s) {
        Employee e1 = read(s); // Check if exists
        if (e1 == null) {
            return false;
        }
        employeeRepository.delete(e1);
        return true;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> searchByAge(int i) {
        return employeeRepository.searchByAge(i);
    }
}
