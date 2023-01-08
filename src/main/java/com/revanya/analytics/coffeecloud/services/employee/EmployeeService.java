package com.revanya.analytics.coffeecloud.services.employee;

import com.revanya.analytics.coffeecloud.services.employee.model.entity.Employee;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface EmployeeService {
    // Retrieves a list of all employees.
    List<Employee> getEmployees();
    // Retrieves the employee with the specified ID.
    Employee getEmployee(Long id);

    // Creates a new employee.
    Employee createEmployee(Employee employee);

    // Updates the employee with the specified ID.
    Employee updateEmployee(Long id, Employee employee);

    // Deletes the employee with the specified ID.
    void deleteEmployee(Long id);

    // Searches for employees based on the specified query.
    List<Employee> searchEmployees(String query);

    // Retrieves a list of employees based on their location.
    List<Employee> getEmployeesByLocation(String location);

    // Retrieves a list of employees based on their role.
    List<Employee> getEmployeesByRole(String role);

    // Retrieves a list of employees who have reached a certain performance threshold.
    List<Employee> getHighPerformingEmployees(int performanceThreshold);

    // Retrieves a list of employees who are eligible for promotion.
    List<Employee> getPromotionEligibleEmployees();

    // Retrieves a list of employees based on their status.
    List<Employee> getEmployeesByStatus(String status);

    // Retrieves a list of employees based on the date they were hired.
    List<Employee> getEmployeesByHireDate(LocalDate startDate, LocalDate endDate);

    // Retrieves a list of employees based on their performance rating.
    List<Employee> getEmployeesByPerformanceRating(int rating);

    // Retrieves a list of employees based on their salary range.
    List<Employee> getEmployeesBySalaryRange(int minSalary, int maxSalary);

    // Retrieves a list of employees based on a predefined category.
    List<Employee> getEmployeesByCategory(String category);

    // Retrieves a list of employees based on their age range.
    List<Employee> getEmployeesByAgeRange(int minAge, int maxAge);

    // Retrieves a list of employees based on their gender.
    List<Employee> getEmployeesByGender(String gender);

    // Retrieves a list of employees based on their occupation.
    List<Employee> getEmployeesByOccupation(String occupation);

    // Retrieves a list of employees based on their education level.
    List<Employee> getEmployeesByEducationLevel(String educationLevel);

    // Retrieves a list of employees based on their marital status.
    List<Employee> getEmployeesByMaritalStatus(String maritalStatus);

}
