package com.example.springquickdemo.annotation;

import java.lang.annotation.*;

/**
 * @author lian
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
