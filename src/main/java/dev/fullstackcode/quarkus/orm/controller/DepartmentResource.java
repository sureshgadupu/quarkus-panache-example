package dev.fullstackcode.quarkus.orm.controller;

import dev.fullstackcode.quarkus.orm.entity.Department;
import dev.fullstackcode.quarkus.orm.service.DepartmentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/department")
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Department> getDepartment(@PathParam(value = "id") Long id) {
        return departmentService.getDepartment(id);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Employee> getEmployeeByDepartment() {
//        return departmentService.
//    }
}