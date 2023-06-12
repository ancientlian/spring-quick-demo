package com.example.springquickdemo.annotation.validator;

import com.example.springquickdemo.exception.ListGroupValidException;
import com.example.springquickdemo.util.ValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lian
 */
public class ListGroupValidator implements ConstraintValidator<ValidListGroup, List> {

    /**
     * 自定义注解@ValidListGroup中指定的校验分组
     */
    private Class<?>[] groupings;

    private boolean quickFail;

    /**
     * Initializes the validator in preparation for
     */
    @Override
    public void initialize(ValidListGroup constraintAnnotation) {
        groupings = constraintAnnotation.groupings();
        quickFail = constraintAnnotation.quickFail();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Implements the validation logic.
     */
    @Override
    public boolean isValid(List value, ConstraintValidatorContext context) {
        Map<Integer, Set<ConstraintViolation<Object>>> errors = new HashMap<>(16);
        for (int i = 0; i < value.size(); i++) {
            Object object = value.get(i);
            // 用工具类获取validator对象，进行分组校验，返回错误结果
            Set<ConstraintViolation<Object>> error = ValidatorUtils.validator.validate(object, groupings);
            if (error.size() > 0) {
                errors.put(i, error);
                if (quickFail) {
                    throw new ListGroupValidException(errors);
                }
            }
        }
        if (errors.size() > 0) {
            throw new ListGroupValidException(errors);
        }
        return true;
    }
}
