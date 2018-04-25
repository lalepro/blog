package com.example.blog.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

//TODO: #3 Add the appropriate JPA annotations to your Post class.
@Entity
@Table(name="posts")
public class Post{

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    @Size(min=1, max=100, message="Blog must have a Title.")
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    @Size(min=1, max=10000, message="Cannot submit a empty blog.")
    private String body;

    //    TODO: Create the connection with a property to a object
    @ManyToOne
    private User user;
//    TODO: add relationship to both constructors

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

//    @OneToOne
//    private PostDetails postDetails;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="posts_categories",
            joinColumns = {@JoinColumn(name="post_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="category_id", referencedColumnName = "id")}
    )

    private List<Category> categories;

    public Post() {
    }
    public Post( String title, String body, User user, List<Category> categories) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.categories = categories;
    }

    public Post(long id, String title, String body, User user, List<PostImage> images, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.images = images;
        this.categories =  categories;
    }

//    public Post( String title, String body, User user, PostDetails postDetails, List<Category> categories) {
//        this.title = title;
//        this.body = body;
//        this.user = user;
////        this.postDetails = postDetails;
//        this.categories = categories;
//    }
//    public Post(long id, String title, String body, User user, PostDetails postDetails, List<PostImage> images, List<Category> categories) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.user = user;
//        this.postDetails = postDetails;
//        this.images = images;
//        this.categories =  categories;
//    }

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
    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

//    public PostDetails getPostDetails() {
//        return postDetails;
//    }

//    public void setPostDetails(PostDetails postDetails) {
//        this.postDetails = postDetails;
//    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
