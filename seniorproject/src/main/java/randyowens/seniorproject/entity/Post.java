package randyowens.seniorproject.entity;

import jakarta.persistence.*;

import java.util.Date;

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
    private User userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book bookId;

    @Column(name = "date_started")
    private java.util.Date dateStarted;

    @Column(name = "date_ended")
    private java.util.Date dateEnded;


    // no arg constructor
    public Post() {

    }

    // default constructor
    public Post(User userId, Book bookId, Date dateStarted, Date dateEnded) {
        this.userId = userId;
        this.bookId = bookId;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
    }


    /* define getters & setters */
    public int getPostId() {
        return postId;
    }

    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }
    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Date getDateStarted() {
        return dateStarted;
    }
    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }
    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
    }
    /* end getters & setters */


    /* define toString */
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", dateStarted=" + dateStarted +
                ", dateEnded=" + dateEnded +
                '}';
    }
    /* end toString */

}
