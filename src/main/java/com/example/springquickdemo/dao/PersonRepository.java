package com.example.springquickdemo.dao;

import com.example.springquickdemo.dto.JpaReturnTestVO;
import com.example.springquickdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lian
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<JpaReturnTestVO> findByLastname(String lastname);

    @Query("select p.id from Person p order by p.id")
    List<JpaReturnTestVO> findByLastname2();

}
