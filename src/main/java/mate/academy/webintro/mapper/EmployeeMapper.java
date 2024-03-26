package mate.academy.webintro.mapper;

import java.util.List;
import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.model.Skill;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

// uses - вказує де ми повинні брати метод для маппінгу, де саме шукати метод "qualifiedByName"
@Mapper(config = MapperConfig.class, uses = DepartmentMapper.class)
public interface EmployeeMapper {
    // беремо поле з об'єкта Employee і сетимо його в DTO у відповідне поле departmentId об'єкта EmployeeDto)
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(target = "skillIds", ignore = true) // коли поля в Model і DTO відрізняються
    // ми ігноруємо при дефолтній реалізації метода toDto
    EmployeeDto toDto(Employee employee);

    @AfterMapping
    default void setSkillsIds(@MappingTarget EmployeeDto employeeDto, Employee employee) {
        List<Long> skillIds = employee.getSkills().stream()
                .map(Skill::getId)
                .toList();
        employeeDto.setSkillIds(skillIds);
    }

    @Mapping(source = "department.id", target = "departmentId")
    EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee);

    // target - поле, яке сетиться в model,
    // source - це поле в JSON об'єкті CreateEmployeeRequestDto
    // qualifiedByName - статичний метод інтерфейсу, який забезпечить маппінг
    @Mapping(target = "department", source = "departmentId", qualifiedByName = "departmentById")
    // ігнор означає, що в нас є метод який мапить поле skills в остовній моделі employee
    @Mapping(target = "skills", ignore = true)
    Employee toModel(CreateEmployeeRequestDto requestDto);

    // для MapStruct метод
    @AfterMapping // відпрацює після toDto
    // поля з requestDto мапяться в employee
    default void setSkills(@MappingTarget Employee employee, CreateEmployeeRequestDto requestDto) {
        List<Skill> skills = requestDto.skills().stream()
                .map(Skill::new)
                .toList();
        employee.setSkills(skills);
    }
}
