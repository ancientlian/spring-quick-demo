package com.example.springquickdemo.annotation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.groups.Default;
import java.lang.annotation.*;

/**
 * @author lian
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ListGroupValidator.class})
public @interface ValidListGroup {

    /**
     * 自定义分组校验属性
     */
    Class<?>[] groupings() default {Default.class};

    String message() default "分组校验参数有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 快速失败
     */
    boolean quickFail() default false;

}
