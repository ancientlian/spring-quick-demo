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
        List<Person> all = personRepository.findAll();
        System.out.println("all = " + all);
        List<JpaReturnTestVO> asd = personRepository.findByLastname("asd");
        for (JpaReturnTestVO person : asd) {
            System.out.println("person.getName() = " + person.getName());
            System.out.println("person.getFirstname() = " + person.getFirstname());
            System.out.println("person.getLastname() = " + person.getLastname());
        }

        List<JpaReturnTestVO> list = personRepository.findAllByName("poi");
        for (JpaReturnTestVO vo : list) {
            System.out.println("vo.getName() = " + vo.getName());
            System.out.println("vo.getFirstname() = " + vo.getFirstname());
            System.out.println("vo.getLastname() = " + vo.getLastname());
        }

        List<JpaReturnTestVO> list2 = personRepository.findAllByName2("poi");
        for (JpaReturnTestVO vo : list2) {
            System.out.println("vo2.getName() = " + vo.getName());
            System.out.println("vo2.getFirstname() = " + vo.getFirstname());
            System.out.println("vo2.getLastname() = " + vo.getLastname());
        }

    }
}
