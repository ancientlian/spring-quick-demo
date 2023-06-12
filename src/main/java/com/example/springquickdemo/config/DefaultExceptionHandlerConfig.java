package com.example.springquickdemo.config;

import com.example.springquickdemo.exception.CommonBindException;
import com.example.springquickdemo.exception.ListGroupValidException;
import com.example.springquickdemo.response.ResponseEnum;
import com.example.springquickdemo.response.ServerResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.ValidationException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 自定义错误处理器
 *
 * @author lian
 */
@Slf4j
@Controller
@RestControllerAdvice
public class DefaultExceptionHandlerConfig {

    /**
     * 参数校验异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<ServerResponseEntity<?>> methodArgumentNotValidExceptionHandler(Exception e) {
        log.error("methodArgumentNotValidExceptionHandler", e);
        List<FieldError> fieldErrors = null;
        if (e instanceof MethodArgumentNotValidException) {
            fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
        }
        if (e instanceof BindException) {
            fieldErrors = ((BindException) e).getBindingResult().getFieldErrors();
        }
        if (fieldErrors == null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ServerResponseEntity.fail(ResponseEnum.METHOD_ARGUMENT_NOT_VALID));
        }

        List<String> defaultMessages = new ArrayList<>(fieldErrors.size());
        for (FieldError fieldError : fieldErrors) {
            defaultMessages.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(ResponseEnum.METHOD_ARGUMENT_NOT_VALID, defaultMessages));
    }

    /**
     * 自定义注解返回异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ServerResponseEntity<?>> validExceptionHandler(ConstraintViolationException e) {
        log.error("ConstraintViolationException ", e);

        // 获取异常信息
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        // 将异常信息收集到Map，key为校验失败的字段，value为失败原因
        Map<Path, String> errorMap = constraintViolations.stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
        // 返回校验失败信息
        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(ResponseEnum.METHOD_ARGUMENT_NOT_VALID, errorMap));

        /*
        List<String> msgList = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            msgList.add(constraintViolation.getPropertyPath() + ":" +constraintViolation.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(ResponseEnum.METHOD_ARGUMENT_NOT_VALID, msgList));
        */
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(CommonBindException.class)
    public ResponseEntity<ServerResponseEntity<?>> unauthorizedExceptionHandler(CommonBindException e) {
        log.error("commonExceptionHandler ", e);

        ServerResponseEntity<?> serverResponseEntity = e.getServerResponseEntity();
        if (serverResponseEntity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(serverResponseEntity);
        }
        // 失败返回消息 状态码固定为直接显示消息的状态码
        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(e.getCode(), e.getMessage()));
    }

    /**
     * 处理自定义集合分组校验注解的校验失败异常
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ServerResponseEntity<?>> handleValidException(ValidationException e) {
        log.error("ValidationException ", e);

        Map<Integer, Map<Path, String>> errorMap = new HashMap<>(8);
        Throwable throwable = e.getCause();
        ListGroupValidException exception = (ListGroupValidException) throwable;
        Map<Integer, Set<ConstraintViolation<Object>>> errors = exception.getErrors();
        // 将异常信息收集到Map，key为集合中校验失败元素的索引，value为校验失败字段和原因
        errors.forEach((k, v) -> {
            errorMap.put(k, v.stream().collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage)));
        });
        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(ResponseEnum.METHOD_ARGUMENT_NOT_VALID, errorMap));
    }

    /**
     * 处理文件上传大小限制
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ServerResponseEntity<?>> handlerMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error("catch MaxUploadSizeExceededException {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(ResponseEnum.MAX_UPLOAD_SIZE));
    }

    /**
     * 其他所有通用异常处理
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServerResponseEntity<?>> exceptionHandler(Exception e) {
        log.error("exceptionHandler ", e);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ServerResponseEntity.fail(ResponseEnum.EXCEPTION));
    }
}