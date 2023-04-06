package randyowens.seniorproject.entity;

import jakarta.persistence.*;

// Represents User adding read books

@Entity
@Table(name = "posts")
public class Post {

    // define fields
    // Posts: post_id, user_id, book_id, date_started, date_ended

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date_started")
    private java.util.Date dateStarted;

    @Column(name = "date_ended")
    private java.util.Date dateEnded;



}
