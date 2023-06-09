package com.example.springquickdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author lian
 * @date 2023/6/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Long id;

    @NotBlank(message = "部门名称不能为空")
    private String name;

    private List<Employee> employeeList;
}