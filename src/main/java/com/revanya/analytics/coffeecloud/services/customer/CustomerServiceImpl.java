package com.revanya.analytics.coffeecloud.services.customer;

import com.revanya.analytics.coffeecloud.services.customer.model.entity.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Customer> getCustomers() {
        return Customer.listAll();
    }

    public Customer getCustomer(Long id) {
        return Customer.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        customer.persist();
        return customer;
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = Customer.findById(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setPassword(customer.getPassword());
        existingCustomer.setLocation(customer.getLocation());
        existingCustomer.setLoyaltyPoints(customer.getLoyaltyPoints());
        existingCustomer.setIsVIP(customer.getIsVIP());
        existingCustomer.setStatus(customer.getStatus());
        existingCustomer.setRegistrationDate(customer.getRegistrationDate());
        existingCustomer.setLastVisitDate(customer.getLastVisitDate());
        existingCustomer.setRating(customer.getRating());
        existingCustomer.setLoyaltyLevel(customer.getLoyaltyLevel());
        existingCustomer.setCategory(customer.getCategory());
        existingCustomer.setPreference(customer.getPreference());
        existingCustomer.setAge(customer.getAge());
        existingCustomer.setGender(customer.getGender());
        existingCustomer.setOccupation(customer.getOccupation());
        existingCustomer.setIncome(customer.getIncome());
        existingCustomer.setMaritalStatus(customer.getMaritalStatus());
        existingCustomer.persist();
        return existingCustomer;
    }


    public void deleteCustomer(Long id) {
        Customer.deleteById(id);
    }

    @Override
    public List<Customer> searchCustomers(String query) {
        return entityManager.createQuery("select c from Customer c where c.name like :query or c.email like :query or c.phone like :query", Customer.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByLocation(String location) {
        return entityManager.createQuery("select c from Customer c where c.location like :location", Customer.class)
                .setParameter("location", "%" + location + "%")
                .getResultList();
    }

    @Override
    public List<Customer> getLoyalCustomers(int loyaltyThreshold) {
        return entityManager.createQuery("select c from Customer c where c.loyaltyPoints >= :loyaltyThreshold", Customer.class)
                .setParameter("loyaltyThreshold", loyaltyThreshold)
                .getResultList();
    }

    @Override
    public List<Customer> getVIPCustomers() {
        return entityManager.createQuery("select c from Customer c where c.isVIP = true", Customer.class)
                .getResultList();
    }



    @Override
    public List<Customer> getCustomersByStatus(String status) {
        return entityManager.createQuery("select c from Customer c where c.status = :status", Customer.class)
                .setParameter("status", status)
                .getResultList();
    }


    @Override
    public List<Customer> getCustomersByRegistrationDate(LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery("select c from Customer c where c.registrationDate between :startDate and :endDate", Customer.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByLastVisitDate(LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery("select c from Customer c where c.lastVisitDate between :startDate and :endDate", Customer.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByRating(int rating) {
        return entityManager.createQuery("select c from Customer c where c.rating = :rating", Customer.class)
                .setParameter("rating", rating)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByLoyaltyLevel(int loyaltyLevel) {
        return entityManager.createQuery("select c from Customer c where c.loyaltyLevel = :loyaltyLevel", Customer.class)
                .setParameter("loyaltyLevel", loyaltyLevel)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByCategory(String category) {
        return entityManager.createQuery("select c from Customer c where c.category = :category", Customer.class)
                .setParameter("category", category)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByPreference(String preference) {
        return entityManager.createQuery("select c from Customer c where c.preference = :preference", Customer.class)
                .setParameter("preference", preference)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByAgeRange(int minAge, int maxAge) {
        return entityManager.createQuery("select c from Customer c where c.age between :minAge and :maxAge", Customer.class)
                .setParameter("minAge", minAge)
                .setParameter("maxAge", maxAge)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByGender(String gender) {
        return entityManager.createQuery("select c from Customer c where c.gender = :gender", Customer.class)
                .setParameter("gender", gender)
                .getResultList();
    }



    @Override
    public List<Customer> getCustomersByOccupation(String occupation) {
        return entityManager.createQuery("select c from Customer c where c.occupation = :occupation", Customer.class)
                .setParameter("occupation", occupation)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByIncomeRange(int minIncome, int maxIncome) {
        return entityManager.createQuery("select c from Customer c where c.income between :minIncome and :maxIncome", Customer.class)
                .setParameter("minIncome", minIncome)
                .setParameter("maxIncome", maxIncome)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByMaritalStatus(String maritalStatus) {
        return entityManager.createQuery("select c from Customer c where c.maritalStatus = :maritalStatus", Customer.class)
                .setParameter("maritalStatus", maritalStatus)
                .getResultList();
    }

}

