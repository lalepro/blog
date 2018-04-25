//package com.example.blog.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_details")
//public class UserDetails {
//    @Id @GeneratedValue
//    private long id;
//
//    @Column(columnDefinition = "Text")
//    private String address;
//
//    @Column(columnDefinition = "TEXT")
//    private String bio;
//
//    @Column(columnDefinition = "TEXT")
//    private String path;
//
//    public UserDetails() {
//    }
//
//    public UserDetails(String address, String bio, String path) {
//        this.address = address;
//        this.bio = bio;
//        this.path = path;
//    }
//
//    public UserDetails(long id, String address, String bio, String path) {
//        this.id = id;
//        this.address = address;
//        this.bio = bio;
//        this.path = path;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//}
