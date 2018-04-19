package com.example.blog.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 11)
    private int age;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 2)
    private String reside_state;


    public Dog() {
    }

    public Dog(int age, String name, String reside_state) {
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReside_state() {
        return reside_state;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }
}
