package za.ac.cput.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    public List<Employee> searchByAge(int i);
}
