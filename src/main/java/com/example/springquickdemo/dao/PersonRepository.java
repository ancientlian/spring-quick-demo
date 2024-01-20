package com.example.springquickdemo.dao;

import com.example.springquickdemo.dto.JpaReturnTestVO;
import com.example.springquickdemo.dto.PersonDTO;
import com.example.springquickdemo.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author lian
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<JpaReturnTestVO> findByLastname(String lastname);

    @Query("select p.firstname as firstname, p.lastname as lastname, p.name as name from Person p where p.name = ?1 order by p.id")
    List<JpaReturnTestVO> findAllByName(String name, Pageable pageable);

    @Query(nativeQuery = true, value =
            "select p.firstname as firstname, p.lastname as lastname, p.name as name from person p where p.name = ?1 order by p.id")
    List<JpaReturnTestVO> findAllByName2(String name);

    @Query("select p.firstname as firstname, p.lastname as lastname, p.name as name from Person p where p.name = ?1 order by p.id")
    List<Map<String, Object>> findAllByName3(String name);
    @Query("select p.firstname, p.lastname, p.name from Person p where p.name = ?1 order by p.id")
    List<Object[]> findAllByName4(String name);

    /**
     * 泛型动态查询投影
     */
    <T> Optional<T> findById(long id, Class<T> type);

    @Query("select new com.example.springquickdemo.dto.PersonDTO(p.name, p.firstname, p.lastname) from Person p where p.firstname = ?1 order by p.id")
    List<PersonDTO> findByFirstname(String firstname);

}
