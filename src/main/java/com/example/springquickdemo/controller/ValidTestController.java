package com.example.springquickdemo.controller;

import com.example.springquickdemo.annotation.validator.Status;
import com.example.springquickdemo.response.ServerResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        System.out.println("================================================");
        System.out.println(param1);
        System.out.println(param2);
        System.out.println("================================================");

        return ServerResponseEntity.success();

    }

}
