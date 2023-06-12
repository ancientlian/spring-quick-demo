package com.example.springquickdemo.model;

import com.example.springquickdemo.annotation.validator.EmployeeGroupSequenceProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

/**
 * @author lian
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@GroupSequenceProvider(EmployeeGroupSequenceProvider.class)
public class Employee {

    public interface Add{}

    public interface Update{}

    @Null(message = "新增ID必需为空", groups = {Add.class})
    @NotNull(message = "更新ID必需不为空", groups = {Update.class})
    private Long id;

    @NotBlank(message = "员工姓名不能为空", groups = Add.class)
    private String name;

    @Positive(message = "年龄必须大于0")
    private Integer age;

    private Department department;
}
