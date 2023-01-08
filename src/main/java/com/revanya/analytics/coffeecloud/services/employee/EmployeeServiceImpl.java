package com.revanya.analytics.coffeecloud.services.employee;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import com.revanya.analytics.coffeecloud.services.employee.model.entity.Employee;

import com.revanya.analytics.coffeecloud.services.employee.model.entity.EmployeeLevel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService, PanacheRepository<Employee> {
    @Override
    public List<Employee> getEmployees() {
        return findAll().list();
    }

    @Override
    public Employee getEmployee(Long id) {
        return findById(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        persist(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = findById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setLocation(employee.getLocation());
        existingEmployee.setRole(employee.getRole());
//        existingEmployee.setShift(employee.getShift());
        existingEmployee.setStatus(employee.getStatus());
        existingEmployee.setHireDate(employee.getHireDate());
        existingEmployee.setPerformanceRating(employee.getPerformanceRating());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setCategory(employee.getCategory());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setOccupation(employee.getOccupation());
        existingEmployee.setEducationLevel(employee.getEducationLevel());
        existingEmployee.setMaritalStatus(employee.getMaritalStatus());
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        deleteById(id);
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        return find("firstName like :query or lastName like :query or email like :query or phoneNumber like :query or location like :query or role like :query or status like :query or performanceRating like :query or salary like :query or category like :query or age like :query or gender like :query or occupation like :query or educationLevel like :query or maritalStatus like :query",
                Parameters.with("query", "%" + query + "%")).list();
    }

    @Override
    public List<Employee> getEmployeesByLocation(String location) {
        return find("location", location).list();
    }

    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return find("role", role).list();
    }

    @Override
    public List<Employee> getHighPerformingEmployees(int performanceThreshold) {
        return find("performanceRating > ?1", performanceThreshold).list();
    }

    @Override
    public List<Employee> getPromotionEligibleEmployees() {
        return find("category = ?1 AND performanceRating > ?2", EmployeeLevel.MANAGER, 3).list();
    }

    @Override
    public List<Employee> getEmployeesByStatus(String status) {
        return find("status", status).list();
    }

    @Override
    public List<Employee> getEmployeesByHireDate(LocalDate startDate, LocalDate endDate) {
        return find("hireDate >= ?1 AND hireDate <= ?2", startDate, endDate).list();
    }


    @Override
    public List<Employee> getEmployeesByPerformanceRating(int rating) {
        return find("performanceRating", rating).list();
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(int minSalary, int maxSalary) {
        return find("salary BETWEEN ?1 AND ?2", minSalary, maxSalary).list();
    }

    @Override
    public List<Employee> getEmployeesByCategory(String category) {
        return find("category", category).list();
    }

    @Override
    public List<Employee> getEmployeesByAgeRange(int minAge, int maxAge) {
        return find("age BETWEEN ?1 AND ?2", minAge, maxAge).list();
    }

    @Override
    public List<Employee> getEmployeesByGender(String gender) {
        return find("gender", gender).list();
    }

    @Override
    public List<Employee> getEmployeesByOccupation(String occupation) {
        return find("occupation", occupation).list();
    }

    @Override
    public List<Employee> getEmployeesByEducationLevel(String educationLevel) {
        return find("educationLevel", educationLevel).list();
    }

    @Override
    public List<Employee> getEmployeesByMaritalStatus(String maritalStatus) {
        return find("maritalStatus", maritalStatus).list();
    }

}