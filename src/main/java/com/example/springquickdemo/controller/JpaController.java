package com.example.springquickdemo.controller;

import com.example.springquickdemo.dao.PersonRepository;
import com.example.springquickdemo.dto.JpaReturnTestVO;
import com.example.springquickdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author lian
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/fun1")
    public void page() {
        // 实体类接受
        List<Person> all = personRepository.findAll();
        System.out.println("all = " + all);

        List<JpaReturnTestVO> asd = personRepository.findByLastname("asd");
        for (JpaReturnTestVO person : asd) {
            System.out.println("person.getName() = " + person.getName());
            System.out.println("person.getFirstname() = " + person.getFirstname());
            System.out.println("person.getLastname() = " + person.getLastname());
        }

        // 必须要有 alias
        List<JpaReturnTestVO> list = personRepository.findAllByName("poi");
        for (JpaReturnTestVO vo : list) {
            System.out.println("vo.getName() = " + vo.getName());
            System.out.println("vo.getFirstname() = " + vo.getFirstname());
            System.out.println("vo.getLastname() = " + vo.getLastname());
            System.out.println("vo.getFullName() = " + vo.getFullName());
            System.out.println("vo.getFullName2() = " + vo.getFullName2());
        }

        // 使用 nativeQuery
        List<JpaReturnTestVO> list2 = personRepository.findAllByName2("poi");
        for (JpaReturnTestVO vo : list2) {
            System.out.println("vo2.getName() = " + vo.getName());
            System.out.println("vo2.getFirstname() = " + vo.getFirstname());
            System.out.println("vo2.getLastname() = " + vo.getLastname());
        }

        // 使用Map接收
        List<Map<String, Object>> poi = personRepository.findAllByName3("poi");
        for (Map<String, Object> stringObjectMap : poi) {
            for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()) {
                System.out.println("entry.getKey() = " + entry.getKey());
                System.out.println("entry.getValue() = " + entry.getValue());
            }
        }


    }
}
