package com.ruturaj.departmentservice.service;

import com.ruturaj.departmentservice.client.EmployeeClient;
import com.ruturaj.departmentservice.model.Department;
import com.ruturaj.departmentservice.repository.DepartmentRepository;
import com.ruturaj.departmentservice.wrapper.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }

    public Department add(Department department) {
        return this.departmentRepository.save(department);
    }

    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }

    public Optional<Department> findById(Long id) {
        return this.departmentRepository.findById(id);
    }

    public List<Department> findAllWithEmployees() {
        List<Department> departments = this.departmentRepository.findAll();
        for (Department department : departments) {
            List<Employee> employees = employeeClient.findByDepartmentId(department.getDepartmentId());
            department.setEmployees(employees);
        }
        return departments;
    }
}
