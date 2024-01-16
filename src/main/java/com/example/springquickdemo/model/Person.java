package com.example.springquickdemo.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author lian
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private String name;

    String firstname, lastname;
    String address;


}
