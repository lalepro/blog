package com.example.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {
    @Id @GeneratedValue
    private long id;

    @Column(columnDefinition = "Text")
    private String address;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(columnDefinition = "TEXT")
    private String path;

    @OneToOne
    private User user;





}
