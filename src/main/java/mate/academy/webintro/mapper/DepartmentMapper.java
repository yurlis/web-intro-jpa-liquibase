package mate.academy.webintro.mapper;

import java.util.Optional;
import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.department.CreateDepartmentRequestDto;
import mate.academy.webintro.dto.department.DepartmentDto;
import mate.academy.webintro.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface DepartmentMapper {
    DepartmentDto toDto(Department department);

    Department toModel(CreateDepartmentRequestDto requestDto);

    @Named("departmentById")
    default Department departmentById(Long id) {
        return Optional.ofNullable(id)
                .map(Department::new)
                .orElse(null);
    }
}
