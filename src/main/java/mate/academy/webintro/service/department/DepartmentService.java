package mate.academy.webintro.service.department;

import mate.academy.webintro.dto.department.CreateDepartmentRequestDto;
import mate.academy.webintro.dto.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto save(CreateDepartmentRequestDto requestDto);

    List<DepartmentDto> findAll();
}
