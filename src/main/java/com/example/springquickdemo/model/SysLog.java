package com.example.springquickdemo.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


/**
 * 系统日志
 * @author lian
 */
@Data
public class SysLog implements Serializable {
    private static final long serialVersionUID = 2625838248848232363L;

    private Long id;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不为空")
    @Size(max = 100, min = 5, message = "字段长度5-100")
    private String username;
    /**
     * 用户操作
     */
    @NotNull
    private String operation;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 执行时长(毫秒)
     */
    private Long time;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

}
