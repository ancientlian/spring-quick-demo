package com.example.springquickdemo.service.impl;

import com.example.springquickdemo.model.Employee;
import com.example.springquickdemo.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author lian
 */
@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void add(Employee employee) {}

}

