package com.revanya.analytics.coffeecloud.services.customer.resource;

import com.revanya.analytics.coffeecloud.services.customer.CustomerService;
import com.revanya.analytics.coffeecloud.services.customer.model.entity.Customer; 

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import static com.revanya.analytics.coffeecloud.common.util.String2LocalDateConvert.convertString2LocalDate;

@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    public Response getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        return Response.ok(customers).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") Long id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(customer).build();
    }

    @POST
    public Response createCustomer(Customer customer) {
        customerService.createCustomer(customer);
        return Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") Long id, Customer customer) {
        Customer existingCustomer = customerService.getCustomer(id);
        if (existingCustomer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        customerService.updateCustomer(id, customer);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Long id) {
        Customer customer = customerService.getCustomer(id);
        if (customer == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        customerService.deleteCustomer(id);
        return Response.ok().build();
    }

    @GET
    @Path("/search")
    public Response searchCustomers(@QueryParam("query") String query) {
        List<Customer> customers = customerService.searchCustomers(query);
        return Response.ok(customers).build();
    }

    @GET
    @Path("/location/{location}")
    public Response getCustomersByLocation(@PathParam("location") String location) {
        List<Customer> customers = customerService.getCustomersByLocation(location);
        return Response.ok(customers).build();
    }

    @GET
    @Path("/loyalty")
    public Response getLoyalCustomers(@QueryParam("loyaltyThreshold") int loyaltyThreshold) {
        List<Customer> customers = customerService.getLoyalCustomers(loyaltyThreshold);
        return Response.ok(customers).build();
    }

    @GET
    @Path("/vip")
    public Response getVIPCustomers() {
        List<Customer> customers = customerService.getVIPCustomers();
        return Response.ok(customers).build();
    }

    @GET
    public Response getCustomersByStatus(@QueryParam("status") String status) {
        List<Customer> customers = customerService.getCustomersByStatus(status);
        return Response.ok(customers).build();
    }

    @GET
    @Path("registration-date")
    public Response getCustomersByRegistrationDate(@QueryParam("startDate") String startDate,
                                                   @QueryParam("endDate") String endDate) {
        List<Customer> customers = customerService.getCustomersByRegistrationDate(
                convertString2LocalDate(startDate), convertString2LocalDate(endDate));
        return Response.ok(customers).build();
    }

    @GET
    @Path("last-visit-date")
    public Response getCustomersByLastVisitDate(@QueryParam("startDate") String startDate,
                                                @QueryParam("endDate") String endDate) {
        List<Customer> customers = customerService.getCustomersByLastVisitDate(convertString2LocalDate(startDate), convertString2LocalDate(endDate));
        return Response.ok(customers).build();
    }

    @GET
    @Path("rating")
    public Response getCustomersByRating(@QueryParam("rating") int rating) {
        List<Customer> customers = customerService.getCustomersByRating(rating);
        return Response.ok(customers).build();
    }

    @GET
    @Path("loyalty-level")
    public Response getCustomersByLoyaltyLevel(@QueryParam("loyaltyLevel") int loyaltyLevel) {
        List<Customer> customers = customerService.getCustomersByLoyaltyLevel(loyaltyLevel);
        return Response.ok(customers).build();
    }

    @GET
    @Path("category")
    public Response getCustomersByCategory(@QueryParam("category") String category) {
        List<Customer> customers = customerService.getCustomersByCategory(category);
        return Response.ok(customers).build();
    }

    @GET
    @Path("/preference/{preference}")
    public Response getCustomersByPreference(@PathParam("preference") String preference) {
        return Response.ok(customerService.getCustomersByPreference(preference)).build();
    }

    @GET
    @Path("/ageRange")
    public Response getCustomersByAgeRange(@QueryParam("minAge") int minAge, @QueryParam("maxAge") int maxAge) {
        return Response.ok(customerService.getCustomersByAgeRange(minAge, maxAge)).build();
    }

    @GET
    @Path("/gender/{gender}")
    public Response getCustomersByGender(@PathParam("gender") String gender) {
        return Response.ok(customerService.getCustomersByGender(gender)).build();
    }

    @GET
    @Path("/occupation/{occupation}")
    public Response getCustomersByOccupation(@PathParam("occupation") String occupation) {
        return Response.ok(customerService.getCustomersByOccupation(occupation)).build();
    }

    @GET
    @Path("/incomeRange")
    public Response getCustomersByIncomeRange(@QueryParam("minIncome") int minIncome, @QueryParam("maxIncome") int maxIncome) {
        return Response.ok(customerService.getCustomersByIncomeRange(minIncome, maxIncome)).build();
    }

    @GET
    @Path("/maritalStatus/{maritalStatus}")
    public Response getCustomersByMaritalStatus(@PathParam("maritalStatus") String maritalStatus) {
        return Response.ok(customerService.getCustomersByMaritalStatus(maritalStatus)).build();
    }

}

