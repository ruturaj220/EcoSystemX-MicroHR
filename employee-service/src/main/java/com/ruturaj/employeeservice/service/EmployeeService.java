package com.ruturaj.employeeservice.service;

import com.ruturaj.employeeservice.model.Employee;
import com.ruturaj.employeeservice.repository.EmployeeRepository;
import com.ruturaj.employeeservice.wrapper.Department;
import com.ruturaj.employeeservice.wrapper.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;

    public EmployeeService(EmployeeRepository employeeRepository, RestTemplate restTemplate) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
    }

    public Employee addUser(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public ResponseTemplateVO getEmployeeWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Employee employee = employeeRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://localhost:4658/department/" + employee.getDepartmentId()
                        , Department.class);

        vo.setEmployee(employee);
        vo.setDepartment(department);
        return vo;
    }

    public List<Employee> findByDepartmentId(Long departmentId) {
        return this.employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }
}
