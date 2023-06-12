package com.example.springquickdemo.controller;

import com.example.springquickdemo.annotation.validator.Status;
import com.example.springquickdemo.annotation.validator.ValidListGroup;
import com.example.springquickdemo.model.Employee;
import com.example.springquickdemo.response.ServerResponseEntity;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.List;

/**
 * @author lian
 */
@RestController
@RequestMapping("/valid/test")
@Validated
public class ValidTestController {

    @GetMapping("/t1")
    @com.example.springquickdemo.annotation.SysLog("page")
    public ServerResponseEntity<String> testFun1(@Status(statusType = {"1", "2"}, message = "param1校验Integer错误") Integer param1,
                                                 @Status(statusType = {"1", "2"}, message = "param2校验int错误") int param2) {
        return ServerResponseEntity.success();
    }
    @GetMapping("/t2")
    @com.example.springquickdemo.annotation.SysLog("page")
    public ServerResponseEntity<String> testFun2(@NotBlank String param1) {
        return ServerResponseEntity.success(param1);
    }

    @PostMapping("/ee/add")
    public ServerResponseEntity<String> addEmployee(@RequestBody @Validated({Employee.Add.class, Default.class}) Employee employee) {
        return ServerResponseEntity.success();
    }

    @PutMapping("/ee/update")
    public ServerResponseEntity<String> updateEmployee(@RequestBody @Validated({Employee.Update.class, Default.class}) Employee employee) {
        return ServerResponseEntity.success();
    }

    @PostMapping("/ee/addList")
    public ServerResponseEntity<String> addEmployeeList(@RequestBody @ValidListGroup(groupings = {Employee.Add.class, Default.class}) List<Employee> employeeList) {
        return ServerResponseEntity.success();
    }

    @PutMapping("/ee/updateList")
    public ServerResponseEntity<String> updateEmployeeList(@RequestBody @ValidListGroup(groupings = {Employee.Update.class, Default.class}, quickFail = true) List<Employee> employeeList) {
        return ServerResponseEntity.success();
    }


}
