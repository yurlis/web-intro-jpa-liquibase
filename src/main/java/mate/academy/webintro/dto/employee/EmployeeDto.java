package mate.academy.webintro.dto.employee;

import java.util.List;
import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
    private List<Long> skillIds;
}
