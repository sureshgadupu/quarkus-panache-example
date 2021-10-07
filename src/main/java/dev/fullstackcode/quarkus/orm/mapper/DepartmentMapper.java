package dev.fullstackcode.quarkus.orm.mapper;

import dev.fullstackcode.quarkus.orm.dto.DepartmentDto;
import dev.fullstackcode.quarkus.orm.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface DepartmentMapper {
    DepartmentDto toResource(Department department);
}
