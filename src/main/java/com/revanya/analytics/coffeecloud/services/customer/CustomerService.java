package com.revanya.analytics.coffeecloud.services.customer;

import com.revanya.analytics.coffeecloud.services.customer.model.entity.Customer;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public interface CustomerService {
    // Retrieves a list of all customers.
    List<Customer> getCustomers();

    // Retrieves the customer with the specified ID.
    Customer getCustomer(Long id);

    // Creates a new customer.
    Customer createCustomer(Customer customer);

    // Updates the customer with the specified ID.
    Customer updateCustomer(Long id, Customer customer);

    // Deletes the customer with the specified ID.
    void deleteCustomer(Long id);

    // Searches for customers based on the specified query.
    List<Customer> searchCustomers(String query);

    // Retrieves a list of customers based on their location.
    List<Customer> getCustomersByLocation(String location);

    // Retrieves a list of customers who have reached a certain loyalty threshold.
    List<Customer> getLoyalCustomers(int loyaltyThreshold);

    // Retrieves a list of VIP customers.
    List<Customer> getVIPCustomers();

    // Retrieves a list of customers based on their status.
    List<Customer> getCustomersByStatus(String status);

    // Retrieves a list of customers based on the date that they registered.
    List<Customer> getCustomersByRegistrationDate(LocalDate startDate, LocalDate endDate);

    // Retrieves a list of customers based on the date of their last visit.
    List<Customer> getCustomersByLastVisitDate(LocalDate startDate, LocalDate endDate);

    // Retrieves a list of customers based on their rating.
    List<Customer> getCustomersByRating(int rating);

    // Retrieves a list of customers based on their loyalty level.
    List<Customer> getCustomersByLoyaltyLevel(int loyaltyLevel);

    // Retrieves a list of customers based on a predefined category.
    List<Customer> getCustomersByCategory(String category);

    // Retrieves a list of customers based on their preferences.
    List<Customer> getCustomersByPreference(String preference);

    // Retrieves a list of customers based on their age range.
    List<Customer> getCustomersByAgeRange(int minAge, int maxAge);

    // Retrieves a list of customers based on their gender.
    List<Customer> getCustomersByGender(String gender);

    // Retrieves a list of customers based on their occupation.
    List<Customer> getCustomersByOccupation(String occupation);

    // Retrieves a list of customers based on their income range.
    List<Customer> getCustomersByIncomeRange(int minIncome, int maxIncome);

    // Retrieves a list of customers based on their marital status.
    List<Customer> getCustomersByMaritalStatus(String maritalStatus);


}


