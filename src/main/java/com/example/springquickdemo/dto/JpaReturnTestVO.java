package com.example.springquickdemo.dto;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lian
 */
public interface JpaReturnTestVO {

    String getFirstname();
    String getLastname();

    String getName();

    @Value("#{target.firstname + '~' + target.lastname}")
    String getFullName();


    default String getFullName2() {
        return getFirstname().concat("-").concat(getLastname());
    }
}
