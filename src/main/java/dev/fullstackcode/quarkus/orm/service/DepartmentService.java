package dev.fullstackcode.quarkus.orm.service;

import dev.fullstackcode.quarkus.orm.dto.DepartmentDto;
import dev.fullstackcode.quarkus.orm.dto.EmployeeDto;
import dev.fullstackcode.quarkus.orm.entity.Department;
import dev.fullstackcode.quarkus.orm.entity.Employee;
import dev.fullstackcode.quarkus.orm.mapper.DepartmentMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentMapper departmentMapper;

    public DepartmentDto getDepartment(Long id) {
        Optional<Department> optionalDepartment = Department.findByIdOptional(id);
        Department department = optionalDepartment.orElseThrow(NotFoundException::new);
        return departmentMapper.toDepartmentDto(department);
    }

    public List<DepartmentDto> getAllDepartments() {
        return departmentMapper.toDepartmentDtoList(Department.listAll());
    }

    @Transactional
    public DepartmentDto createDepartment(DepartmentDto department) {

        Department entity = departmentMapper.toDepartmentEntity(department);
        Department.persist(entity);

        if(entity.isPersistent()) {
            Optional<Department> optionalDept = Department.findByIdOptional(entity.id);
            entity = optionalDept.orElseThrow(NotFoundException::new);
            return departmentMapper.toDepartmentDto(entity);
        } else {
            throw new PersistenceException();
        }

    }
}
