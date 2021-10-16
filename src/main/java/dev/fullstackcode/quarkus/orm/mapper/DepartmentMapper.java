package dev.fullstackcode.quarkus.orm.mapper;

import dev.fullstackcode.quarkus.orm.dto.DepartmentDto;
import dev.fullstackcode.quarkus.orm.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface DepartmentMapper {
    DepartmentDto toDepartmentDto(Department department);
    List<DepartmentDto> toDepartmentDtoList(List<Department> departments);
    Department toDepartmentEntity(DepartmentDto departmentDto);
}
