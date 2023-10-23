package com.ruturaj.departmentservice.controller;

import com.ruturaj.departmentservice.model.Department;
import com.ruturaj.departmentservice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add : {}",department);
        return this.departmentService.add(department);
    }

    @RequestMapping
    public List<Department> getAll(){
        LOGGER.info("Department find");
        return this.departmentService.getAll();
    }

    @RequestMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id){
        LOGGER.info("Department find with {} id",id);
        return this.departmentService.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> FindAllWithEmployees(){
        LOGGER.info("Department find with employees");
        return this.departmentService.findAllWithEmployees();
    }
}
