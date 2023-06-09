package com.example.springquickdemo.service;

import com.example.springquickdemo.model.Employee;

import javax.validation.Valid;

/**
 * @author lian
 */
public interface EmployeeService {

    void add(@Valid Employee employee);
}
