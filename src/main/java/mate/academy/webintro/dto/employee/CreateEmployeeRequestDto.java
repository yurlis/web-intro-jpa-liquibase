package mate.academy.webintro.dto.employee;

import java.util.List;

public record CreateEmployeeRequestDto(
        String name,
        String email,
        Long departmentId,
        List<Long> skills
) {
}