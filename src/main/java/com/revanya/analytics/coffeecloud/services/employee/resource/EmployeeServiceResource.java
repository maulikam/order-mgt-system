package com.revanya.analytics.coffeecloud.services.employee.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revanya.analytics.coffeecloud.services.employee.EmployeeService;
import com.revanya.analytics.coffeecloud.services.employee.model.entity.Employee;

import java.util.List;

@Path("/api/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@Tag(Tagname = "employees")
public class EmployeeServiceResource {
    @Inject
    EmployeeService employeeService;

    @GET
//    @Operation(summary = "Get all employees")
    public Response getEmployees() {
        return Response.ok(employeeService.getEmployees()).build();
    }

    @GET
    @Path("/{id}")
//    @Operation(summary = "Get an employee by ID")
    public Response getEmployee(@PathParam("id") Long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(employee).build();
    }

    @POST
    @Path("/")
//    @Operation(summary = "Creates a new employee.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) {
        employeeService.createEmployee(employee);
        return Response.ok(employee).build();
    }

    @PUT
    @Path("/{id}")
//    @Operation(summary = "Updates the employee with the specified ID.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") Long id, Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return Response.ok(updatedEmployee).build();
    }

    @DELETE
    @Path("/{id}")
//    @Operation(summary = "Deletes the employee with the specified ID.")
    public Response deleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteEmployee(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/search")
//    @Operation(summary = "Searches for employees based on the specified query.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchEmployees(@QueryParam("query") String query) {
        List<Employee> employees = employeeService.searchEmployees(query);
        return Response.ok(employees).build();
    }

    @GET
    @Path("/location/{location}")
//    @Operation(summary = "Retrieves a list of employees based on their location.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByLocation(@PathParam("location") String location) {
        List<Employee> employees = employeeService.getEmployeesByLocation(location);
        return Response.ok(employees).build();
    }

    @GET
    @Path("/role/{role}")
//    @Operation(summary = "Retrieves a list of employees based on their role.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByRole(@PathParam("role") String role) {
        List<Employee> employees = employeeService.getEmployeesByRole(role);
        return Response.ok(employees).build();
    }

    @GET
    @Path("/high-performers")
//    @Operation(summary = "Retrieves a list of employees who have reached a certain performance threshold.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHighPerformingEmployees(@QueryParam("threshold") int threshold) {
        List<Employee> employees = employeeService.getHighPerformingEmployees(threshold);
        return Response.ok(employees).build();
    }

    @GET
    @Path("/eligible-for-promotion")
//    @Operation(summary = "Get promotion eligible employees", description = "Retrieves a list of employees who are eligible for promotion")
    public Response getPromotionEligibleEmployees() {
        List<Employee> employees = employeeService.getPromotionEligibleEmployees();
        return Response.ok(employees).build();
    }


    @GET
    @Path("/status/{status}")
//    @Operation(summary = "Get employees by status", description = "Retrieves a list of employees based on their status")
    public Response getEmployeesByStatus(@PathParam("status") String status) {
        List<Employee> employees = employeeService.getEmployeesByStatus(status);
        return Response.ok(employees).build();
    }

    @GET
    @Path("/get-employees-by-performance-rating/{rating}")
//    @Operation(summary = "Get employees by performance rating")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByPerformanceRating(@PathParam("rating") int rating) {
        return Response.ok(employeeService.getEmployeesByPerformanceRating(rating)).build();
    }

    @GET
    @Path("/get-employees-by-salary-range/{minSalary}/{maxSalary}")
//    @Operation(summary = "Get employees by salary range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesBySalaryRange(@PathParam("minSalary") int minSalary, @PathParam("maxSalary") int maxSalary) {
        return Response.ok(employeeService.getEmployeesBySalaryRange(minSalary, maxSalary)).build();
    }

    @GET
    @Path("/get-employees-by-category/{category}")
//    @Operation(summary = "Get employees by category")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByCategory(@PathParam("category") String category) {
        return Response.ok(employeeService.getEmployeesByCategory(category)).build();
    }

    @GET
    @Path("/get-employees-by-age-range/{minAge}/{maxAge}")
//    @Operation(summary = "Get employees by age range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByAgeRange(@PathParam("minAge") int minAge, @PathParam("maxAge") int maxAge) {
        return Response.ok(employeeService.getEmployeesByAgeRange(minAge, maxAge)).build();
    }

    @GET
    @Path("/get-employees-by-gender/{gender}")
//    @Operation(summary = "Get employees by gender")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByGender(@PathParam("gender") String gender) {
        return Response.ok(employeeService.getEmployeesByGender(gender)).build();
    }

    @GET
    @Path("/get-employees-by-occupation/{occupation}")
//    @Operation(summary = "Get employees by occupation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByOccupation(@PathParam("occupation") String occupation) {
        return Response.ok(employeeService.getEmployeesByOccupation(occupation)).build();
    }

    @GET
    @Path("/education-level/{educationLevel}")
    public Response getEmployeesByEducationLevel(@PathParam("educationLevel") String educationLevel) {
        List<Employee> employees = employeeService.getEmployeesByEducationLevel(educationLevel);
        return Response.ok(employees).build();
    }

//    @Operation(summary = "Retrieves a list of employees based on their marital status.")
    @GET
    @Path("/marital-status/{maritalStatus}")
    public Response getEmployeesByMaritalStatus(@PathParam("maritalStatus") String maritalStatus) {
        List<Employee> employees = employeeService.getEmployeesByMaritalStatus(maritalStatus);
        return Response.ok(employees).build();
    }





}
