package mate.academy.webintro.repository.employee;

import mate.academy.webintro.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Var. 1
    //List<Employee> findAllByNameContainsIgnoreCase(String name);

    // Var. 2 - JPQL
    //@Query("from Employee e where upper(e.name) like upper(:name)")

    // Var. 3 - Native Query
    @Query(value = "SELECT * FROM employees WHERE UPPER(name) LIKE %:name%", nativeQuery = true)
    List<Employee> findAllByN(String name);
}
