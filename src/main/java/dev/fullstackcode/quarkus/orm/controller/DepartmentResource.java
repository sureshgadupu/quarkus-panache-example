package dev.fullstackcode.quarkus.orm.controller;

import dev.fullstackcode.quarkus.orm.dto.DepartmentDto;
import dev.fullstackcode.quarkus.orm.dto.EmployeeDto;
import dev.fullstackcode.quarkus.orm.service.DepartmentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/department")
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;


    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DepartmentDto getDepartment(@PathParam(value = "id") Long id) {
        return departmentService.getDepartment(id);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @POST
    public DepartmentDto createEmployee(DepartmentDto department) {
        return departmentService.createDepartment(department);
    }

}