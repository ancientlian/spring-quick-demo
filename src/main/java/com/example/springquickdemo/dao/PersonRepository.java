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

    @Query("select p.firstname as firstname, p.lastname as lastname, p.name as name from Person p where p.name = ?1 order by p.id")
    List<JpaReturnTestVO> findAllByName(String name);

    @Query(nativeQuery = true, value =
            "select p.firstname as firstname, p.lastname as lastname, p.name as name from person p where p.name = ?1 order by p.id")
    List<JpaReturnTestVO> findAllByName2(String name);

}
