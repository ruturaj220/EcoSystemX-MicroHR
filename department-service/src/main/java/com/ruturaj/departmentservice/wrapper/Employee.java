package com.ruturaj.departmentservice.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long userId;
    private String name;
    private int age;
    private String position;
    private Long departmentId;
}
