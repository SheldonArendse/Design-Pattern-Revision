package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EmployeeFactory.class)
class EmployeeFactoryTest {
    @Order(1)
    @Test
    void testBuildEmployee() {
        Employee e1 = EmployeeFactory.buildEmployee("324345511", "Sheldon", "Arendse", 24);
        assertNotNull(e1);
        System.out.println(e1);
    }

    @Order(2)
    @Test
    void testBuildEmployeeNoId() {
        Employee e2 = EmployeeFactory.buildEmployee("Logan", "Coghill", 22);
        assertNotNull(e2);
        System.out.println(e2);
    }

    @Order(3)
    @Test
    void testEmployeeEmptyString() {
        Employee e3 = EmployeeFactory.buildEmployee("324345511", "", "Arendse", 24);
        assertNotNull(e3);
        System.out.println(e3);
    }

    @Order(4)
    @Test
    void testEmployeeInvalidInt() {
        Employee e4 = EmployeeFactory.buildEmployee("324345511", "", "Arendse", -1);
        assertNotNull(e4);
        System.out.println(e4);
    }
}