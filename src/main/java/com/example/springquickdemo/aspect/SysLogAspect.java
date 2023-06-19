package com.example.springquickdemo.aspect;

import cn.hutool.core.date.SystemClock;
import com.example.springquickdemo.service.SysLogService;

import com.example.springquickdemo.util.IpHelper;

import com.example.springquickdemo.util.Json;
import com.example.springquickdemo.model.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author lian
 */
@Aspect
@Component
@Slf4j
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint joinPoint, com.example.springquickdemo.annotation.SysLog sysLog) throws Throwable {
        long beginTime = SystemClock.now();
        //执行方法
        Object result = joinPoint.proceed();
        //执行时长(毫秒)
        long time = SystemClock.now() - beginTime;

        SysLog sysLogEntity = new SysLog();
        if (sysLog != null) {
            //注解上的描述
            sysLogEntity.setOperation(sysLog.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        sysLogEntity.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params = Json.toJsonString(args);
        sysLogEntity.setParams(params);

        //设置IP地址
        sysLogEntity.setIp(IpHelper.getIpAddr());

        //用户名
        //sysLogEntity.setUsername(username);

        sysLogEntity.setTime(time);
        sysLogEntity.setCreateDate(new Date());

        //保存系统日志
        //sysLogService.save(sysLogEntity);

        log.info("@Around sysLogEntity = " + sysLogEntity);
        return result;
    }

}
