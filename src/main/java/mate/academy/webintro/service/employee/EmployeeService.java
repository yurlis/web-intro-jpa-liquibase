package mate.academy.webintro.service.employee;

import java.util.List;

import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;

public interface EmployeeService {
    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    EmployeeWithoutSkillsDto findById(Long id);

    //List<EmployeeDto> findAll();
    List<EmployeeWithoutSkillsDto> findAll();

    List<EmployeeWithoutSkillsDto> getAllByName(String name);
}
