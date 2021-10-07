package dev.fullstackcode.quarkus.orm.service;

import dev.fullstackcode.quarkus.orm.entity.Department;
import dev.fullstackcode.quarkus.orm.entity.Employee;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentService {

    public Optional<Department> getDepartment(Long id) {
        return Department.findByIdOptional(id);
    }

    public List<Department> getAllDepartments() {
        return Department.listAll();
    }
}
