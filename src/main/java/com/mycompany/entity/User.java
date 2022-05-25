package com.mycompany.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String password;
    private String about;
    private Date age;
    private Date addDate;
    private Date updateDate;
    private Address address;
    private List<Link> links;
    private List<Phone> phones;
    private List<Skill> skills;
    private Nationality nat;

    @ManyToMany
    private List<Education> unies;

}
