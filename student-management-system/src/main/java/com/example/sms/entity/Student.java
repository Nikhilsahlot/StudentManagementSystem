package com.example.sms.entity;

import jakarta.persistence.*;

@Entity// to tell this is an entity or a table
@Table(name="students")//to define table name
public class Student {
    @Id//to define primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false)//to tell column name
    private String firstname;
    @Column(name = "last_name")//if we do not add @Column annotation jpa will give lastname as column name
    private String lastname;
    @Column(name = "email")
    private String email;

    public Student(){

    }
    public Student(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
