package mate.academy.webintro.dto.employee;

import lombok.Data;

@Data
public class EmployeeWithoutSkillsDto {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
}
