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
            System.out.println(person);
            System.out.println("person.getFirstname() = " + person.getFirstname());
        }

        List<JpaReturnTestVO> list = personRepository.findByLastname2();
        for (JpaReturnTestVO vo : list) {
            System.out.println("vo = " + vo);
        }

    }
}
