package com.example.blog.models;

import javax.persistence.*;
import java.util.List;

//TODO: #3 Add the appropriate JPA annotations to your Post class.
@Entity
@Table(name="posts")
public class Post{

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, columnDefinition = "Text")
    private String body;

    //    TODO: Create the connection with a property to a object
    @OneToOne
    private User user;
//    TODO: add relationship to both constructors

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @OneToOne
    private PostDetails postDetails;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_categoies",
            joinColumns = {@JoinColumn(name="post_id")},
            inverseJoinColumns = {@JoinColumn(name="category_id")}
    )

    private List<Categories> categories;

    public Post() {
    }

    public Post( String title, String body, User user, PostDetails postDetails, List<Categories> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.postDetails = postDetails;
        this.categories = categories;
    }
    public Post(long id, String title, String body, User user, PostDetails postDetails, List<PostImage> images, List<Categories> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.postDetails = postDetails;
        this.images = images;
        this.categories =  categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
