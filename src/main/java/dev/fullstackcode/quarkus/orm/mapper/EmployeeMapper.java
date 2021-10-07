package dev.fullstackcode.quarkus.orm.mapper;

import dev.fullstackcode.quarkus.orm.dto.EmployeeDto;
import dev.fullstackcode.quarkus.orm.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface EmployeeMapper {
    EmployeeDto toResource(Employee employee);
    List<EmployeeDto> toEmployeeList(List<Employee> employee);
}
