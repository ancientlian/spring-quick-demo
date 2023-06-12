package com.example.springquickdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validator;

/**
 * 工具类
 * @author lian
 */
@Component
public class ValidatorUtils {
    public static Validator validator;

    /**
     * 注入Validator对象
     */
    @Autowired
    public void setValidator(Validator validator) {
        ValidatorUtils.validator = validator;
    }
}
