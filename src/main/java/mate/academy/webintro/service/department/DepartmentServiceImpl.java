package mate.academy.webintro.service.department;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.department.CreateDepartmentRequestDto;
import mate.academy.webintro.dto.department.DepartmentDto;
import mate.academy.webintro.mapper.DepartmentMapper;
import mate.academy.webintro.model.Department;
import mate.academy.webintro.repository.department.DepartmentRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto save(CreateDepartmentRequestDto requestDto) {
        Department department = departmentMapper.toModel(requestDto);
        return departmentMapper.toDto(departmentRepository.save(department));
    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDto)
                .toList();
    }
}
