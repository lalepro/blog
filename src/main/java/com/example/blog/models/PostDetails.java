//package com.example.blog.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "post_details")
//public class PostDetails {
//
//    @Id @GeneratedValue
//    private long id;
//
//    @Column
//    private String location;
//
//    @Column(columnDefinition = "Text")
//    private String question;
//
//    @Column(columnDefinition = "Text")
//    private String answer;
//
//
//    public PostDetails(String location, String question, String answer) {
//        this.location = location;
//        this.question = question;
//        this.answer = answer;
//    }
//    public PostDetails(long id, String location, String question, String answer) {
//        this.id = id;
//        this.location = location;
//        this.question = question;
//        this.answer = answer;
//    }
//    public PostDetails() {
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
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
//}
