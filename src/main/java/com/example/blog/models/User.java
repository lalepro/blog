package com.example.blog.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @Size(min=1, max=100, message="Username Required")
    private String username;

    @Column(nullable = false, unique = true)
    @Size(min=1, max=100, message="Email Required")
//    TODO: @Email annotation
    private String email;

    @Column(nullable = false)
    @Size(min=1, max=100, message="Password Required")
//    TODO: annotation for length, and characters needed, uppercase, lowercase
    private String password;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

//    @OneToOne
//    private UserDetails userDetails;
public User(User copy) {
    this.id = copy.id;
    this.username = copy.username;
    this.email = copy.email;
    this.password = copy.password;
    this.posts = copy.posts;
}

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

//    public User(String username, String email, String password, UserDetails userDetails) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.userDetails = userDetails;
//    }

//    public User(long id, String username, String email, String password, UserDetails userDetails) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.userDetails = userDetails;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//    public UserDetails getUserDetails() {
//        return userDetails;
//    }

//    public void setUserDetails(UserDetails userDetails) {
//        this.userDetails = userDetails;
//    }
public List<Post> getPosts() {
    return posts;
}

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
