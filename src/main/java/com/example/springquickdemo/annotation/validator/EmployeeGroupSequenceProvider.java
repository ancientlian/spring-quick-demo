package com.example.springquickdemo.annotation.validator;

import com.example.springquickdemo.model.Employee;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 属性字段关联校验
 *
 * @author lian
 */
public class EmployeeGroupSequenceProvider implements DefaultGroupSequenceProvider<Employee> {

    @Override
    public List<Class<?>> getValidationGroups(Employee employee) {
        // 创建需要校验的分组集合
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        // 添加默认分组Default
        defaultGroupSequence.add(Employee.class);
        // 根据employee的id是否为空，决定是否加上Add组
        Optional.ofNullable(employee).ifPresent(e -> {
            Long id = e.getId();
            if (id == null) {
                // id为空，加上Add组
                defaultGroupSequence.add(Employee.Add.class);
            }
        });
        return defaultGroupSequence;
    }
}
