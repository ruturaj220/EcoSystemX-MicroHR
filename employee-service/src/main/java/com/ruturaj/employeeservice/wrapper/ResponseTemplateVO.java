package com.ruturaj.employeeservice.wrapper;

import com.ruturaj.employeeservice.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO
{
    private Employee employee;
    private Department department;
}
