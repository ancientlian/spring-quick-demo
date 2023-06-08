package com.example.springquickdemo.exception;

import com.example.springquickdemo.response.ResponseEnum;
import com.example.springquickdemo.response.ServerResponseEntity;
import lombok.Getter;

@Getter
public class CommonBindException extends RuntimeException{
   
    //@java.io.Serial
    private static final long serialVersionUID = -4137688758944857209L;

    /**
     * http状态码
     */
    private String code;

    private Object object;

    private ServerResponseEntity<?> serverResponseEntity;

    public CommonBindException(ResponseEnum responseEnum) {
        super(responseEnum.getMsg());
        this.code = responseEnum.value();
    }

    public CommonBindException(ResponseEnum responseEnum, String msg) {
        super(msg);
        this.code = responseEnum.value();
    }

    public CommonBindException(ServerResponseEntity<?> serverResponseEntity) {
        this.serverResponseEntity = serverResponseEntity;
    }

    public CommonBindException(String msg) {
        super(msg);
        this.code = ResponseEnum.SHOW_FAIL.value();
    }

    public CommonBindException(String msg, Object object) {
        super(msg);
        this.code = ResponseEnum.SHOW_FAIL.value();
        this.object = object;
    }

}
