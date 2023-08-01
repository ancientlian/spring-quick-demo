package com.example.springquickdemo.dto;

import com.example.springquickdemo.model.SysLog;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lian
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class SysLogVO extends SysLog implements Serializable {

    private String createDateTime;


}
