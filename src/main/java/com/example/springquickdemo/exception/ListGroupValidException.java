package com.example.springquickdemo.exception;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import java.util.Map;
import java.util.Set;

/**
 * @author lian
 */
@Getter
@Setter
public class ListGroupValidException extends RuntimeException {

    private Map<Integer, Set<ConstraintViolation<Object>>> errors;

    public ListGroupValidException(Map<Integer, Set<ConstraintViolation<Object>>> errors) {
        this.errors = errors;
    }

}