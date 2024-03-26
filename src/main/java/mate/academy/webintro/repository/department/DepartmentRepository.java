package mate.academy.webintro.repository.department;

import mate.academy.webintro.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}