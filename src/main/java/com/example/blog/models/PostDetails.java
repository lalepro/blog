package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostDetails {

    @Id @GeneratedValue
    private long id;

    @Column
    private String location;



}
