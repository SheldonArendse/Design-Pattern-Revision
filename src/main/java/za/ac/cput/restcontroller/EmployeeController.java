package za.ac.cput.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee obj) {
        Employee e1 = EmployeeFactory.buildEmployee(obj.getName(), obj.getSurname(), obj.getAge());

        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.create(e1));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Employee> read(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.read(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee obj) {
        Employee e1 = EmployeeFactory.buildEmployee(obj.getEmployeeId(), obj.getName(), obj.getSurname(), obj.getAge());
        if(e1 == null) {
            return null;
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.update(e1));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.delete(id));
    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity<List<Employee>> searchByAge(@PathVariable int age) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.searchByAge(age));
    }
}
