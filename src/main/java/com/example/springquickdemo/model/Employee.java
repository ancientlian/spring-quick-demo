package com.example.springquickdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * @author lian
 * @date 2023/6/9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;

    @NotBlank(message = "员工姓名不能为空")
    private String name;

    @Positive(message = "年龄必须大于0")
    private Integer age;

    private Department department;
}
