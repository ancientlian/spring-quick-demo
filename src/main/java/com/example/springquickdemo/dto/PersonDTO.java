package com.example.springquickdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author lian
 */
@Data
@ToString
//@NoArgsConstructor 不可写，否则会出现类型转换错误
@AllArgsConstructor // 必须写，转换时会调用
public class PersonDTO {
    private String name;

    private String firstname;

    private String lastname;

}
