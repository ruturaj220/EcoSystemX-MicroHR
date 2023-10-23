package com.ruturaj.employeeservice.repository;

import com.ruturaj.employeeservice.model.Employee;
import com.ruturaj.employeeservice.wrapper.ResponseTemplateVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByUserId(Long userId);

    List<Employee> findByDepartmentId(Long departmentId);
}
