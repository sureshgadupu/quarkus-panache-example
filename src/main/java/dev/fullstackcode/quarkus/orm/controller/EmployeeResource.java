package dev.fullstackcode.quarkus.orm.controller;

import dev.fullstackcode.quarkus.orm.dto.EmployeeDto;
import dev.fullstackcode.quarkus.orm.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {


    @Inject
    EmployeeService empService;


    @GET
    @Path("/{id}")
    public EmployeeDto getEmployee(@PathParam(value = "id") Long id) {
        return empService.getEmployee(id);
    }

    @GET
    public List<EmployeeDto> getAllEmployees() {
        return empService.getAllEmployees();
    }


    @GET
    @Path("/dept/{id}")
    public List<EmployeeDto> getEmployeesByDepartment(@PathParam(value = "id") Long departmentId) {
        return empService.getEmployeesByDepartment(departmentId);
    }

    @GET
    @Path("/search/{name}")
    public List<EmployeeDto> searchEmpsByName(@PathParam(value = "name") String name) {

        return empService.searchEmpsByName(name);
    }

    @POST
    public EmployeeDto createEmployee(EmployeeDto employee) {
        return empService.createEmployee(employee);
    }

    @PUT
    @Path("/{id}")
    public EmployeeDto updateEmployee(@PathParam(value = "id") Long id, EmployeeDto employee) {

        if (employee.getFirst_name() == null || employee.getLast_name() == null) {
            throw new WebApplicationException("first_name or last_name was not set on request.", 422);
        }
        return empService.updateEmployee(id, employee);
    }

    @PUT
    public EmployeeDto updateEmployee(EmployeeDto employee) {

        if (employee.getFirst_name() == null || employee.getLast_name() == null) {
            throw new WebApplicationException("first_name or last_name was not set on request.", 422);
        }
        return empService.updateEmployee(employee);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam(value = "id") Long id) {
        return empService.deleteEmployee(id);
    }

}