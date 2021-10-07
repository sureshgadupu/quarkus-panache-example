package dev.fullstackcode.quarkus.orm.dto;

import dev.fullstackcode.quarkus.orm.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDto {

    private Long id;
    private String name;
    public List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}