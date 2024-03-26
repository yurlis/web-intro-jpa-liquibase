package mate.academy.webintro.service.employee;

import java.util.List;
import java.util.Random;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.webintro.exception.EntityNotFoundException;
import mate.academy.webintro.mapper.EmployeeMapper;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.repository.employee.EmployeeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto save(CreateEmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toModel(requestDto);
        employee.setSocialSecurityNumber("abc" + new Random().nextInt(1000));
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeWithoutSkillsDto findById(Long id) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        if (optionalEmployee.isPresent()) {
//            return employeeMapper.toDto(optionalEmployee.get());
//        }
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find employee by id " + id)
        );
        return employeeMapper.toEmployeeWithoutSkillsDto(employee);
    }

//    @Override
//    public List<EmployeeDto> findAll() {
//        return employeeRepository.findAll().stream()
//                .map(employeeMapper::toDto)
//                .toList();
//    }
    @Override
    public List<EmployeeWithoutSkillsDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeWithoutSkillsDto)
                .toList();
    }

    @Override
    public List<EmployeeWithoutSkillsDto> getAllByName(String name) {
//        return employeeRepository.findAllByNameContainsIgnoreCase(name).stream()
        return employeeRepository.findAllByN(name).stream()
                .map(employeeMapper::toEmployeeWithoutSkillsDto)
                .toList();
    }
}
