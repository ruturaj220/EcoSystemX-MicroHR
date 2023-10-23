package com.ruturaj.employeeservice.controller;

import com.ruturaj.employeeservice.model.Employee;
import com.ruturaj.employeeservice.service.EmployeeService;
import com.ruturaj.employeeservice.wrapper.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public Employee addUser(@RequestBody Employee employee){
        log.info("employee added : {}",employee);
        return this.employeeService.addUser(employee);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployee(){
        log.info("list of employees");
        return this.employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getEmployeeWithDepartment(@PathVariable("id") Long userId){
        log.info("employee find with department : {}",userId);
        return this.employeeService.getEmployeeWithDepartment(userId);
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartmentId(@PathVariable("id") Long departmentId){
        log.info("employee find by department id : {}",departmentId);
        return this.employeeService.findByDepartmentId(departmentId);
    }

}
