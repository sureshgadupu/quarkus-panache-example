package dev.fullstackcode.quarkus.orm.service;

import dev.fullstackcode.quarkus.orm.dto.EmployeeDto;
import dev.fullstackcode.quarkus.orm.entity.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeService {

    public Employee getEmployee(Long id) {
        return Employee.findById(id);
    }

    public List<Employee> getAllEmployees() {
        return Employee.listAll();
    }

    public List<Employee> getEmployeesByDepartment(Long deptId) {
        return Employee.findEmployeesByDepartmentId(deptId);
    }

    public List<Employee> searchEmpsByName(String name) {
        return Employee.searchEmpsByName(name);
    }

    @Transactional
    public Employee createEmployee(Employee employee) {

        Employee.persist(employee);
        if(employee.isPersistent()) {
         Optional<Employee> optionalEmp = Employee.findByIdOptional(employee.id);
         return optionalEmp.orElseThrow(NotFoundException::new);

        } else {
            throw new PersistenceException();
        }

    }

    @Transactional
    public Employee updateEmployee(Long id, Employee employee) {
        Employee entity  = Employee.findById(id);
        if(entity == null) {
            throw new WebApplicationException("Employee with id of " + id + " does not exist.", 404);
        }
        entity.last_name = employee.last_name ;
        entity.first_name = employee.first_name;
        entity.birth_date = employee.birth_date;
        entity.hire_date = employee.hire_date;
        entity.department = employee.department;
        // entity =  Employee.getEntityManager().merge(employee);
        return entity;
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {
        Employee entity  = Employee.findById(employee.id);
        if(entity == null) {
            throw new WebApplicationException("Employee with id " + employee.id + " does not exist.", 404);
        }
         entity =  Employee.getEntityManager().merge(employee);
        System.out.println(entity.department.id);
         return entity;
    }

    @Transactional
    public Response deleteEmployee(Long id) {

        Employee emp  = Employee.findById(id);
        if(emp == null) {
            throw new WebApplicationException("Employee with id of " + id + " does not exist.", 404);
        }
        emp.delete();

       // Employee.deleteById(id);
        return Response.status(204).build();

    }
}
