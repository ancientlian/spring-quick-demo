package com.example.springquickdemo.controller;


import com.example.springquickdemo.model.SysLog;
import com.example.springquickdemo.service.SysLogService;
import com.example.springquickdemo.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @GetMapping("/page")
    @com.example.springquickdemo.annotation.SysLog("page")
    public void page(SysLog sysLog, PageParam<SysLog> page) {

        System.out.println(sysLog);
        System.out.println(page);
        System.out.println("================================================");
        System.out.println("=========================123=======================");

    }
}
