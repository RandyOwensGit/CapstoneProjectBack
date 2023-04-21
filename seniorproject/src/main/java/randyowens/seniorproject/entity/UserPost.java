//package randyowens.seniorproject.entity;
//
//import jakarta.persistence.*;
//import randyowens.seniorproject.utils.ReadStateEnum;
//
//import java.util.Date;
//
//// Represents User adding read books
//
//@Entity
//@Table( name = "user_posts" )
//public class UserPost {
//
//    // define fields
//    // Posts: post_id, user_id, book_id, read_state(enum), date_started, date_ended
//    // enum values not_reading, reading, finished
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column( name = "post_id" )
//    private int postId;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn( name = "user_id" )
//    private User userId;
//
//    @Column( name = "read_state" )
//    @Enumerated(EnumType.ORDINAL)
//    private ReadStateEnum readState;
//
//    @Column( name = "date_started" )
//    private java.util.Date dateStarted;
//
//    @Column( name = "date_ended" )
//    private java.util.Date dateEnded;
//
//
//    // no arg constructor
//    public UserPost() {
//
//    }
//
//    // default constructor
//    public UserPost(User userId, ReadStateEnum readState, Date dateStarted, Date dateEnded) {
//        this.userId = userId;
//        this.readState = readState;
//        this.dateStarted = dateStarted;
//        this.dateEnded = dateEnded;
//    }
//
//
//    /* define getters & setters */
//    public int getPostId() {
//        return postId;
//    }
//
//    public User getUserId() {
//        return userId;
//    }
//    public void setUserId(User userId) {
//        this.userId = userId;
//    }
//
//    public ReadStateEnum getReadState() { return readState; }
//    public void setReadState(ReadStateEnum readState) { this.readState = readState; }
//
//    public Date getDateStarted() {
//        return dateStarted;
//    }
//    public void setDateStarted(Date dateStarted) {
//        this.dateStarted = dateStarted;
//    }
//
//    public Date getDateEnded() {
//        return dateEnded;
//    }
//    public void setDateEnded(Date dateEnded) {
//        this.dateEnded = dateEnded;
//    }
//    /* end getters & setters */
//
//
//    /* define toString */
//    @Override
//    public String toString() {
//        return "Post{" +
//                "postId=" + postId +
//                ", userId=" + userId +
//                ", readState=" + readState +
//                ", dateStarted=" + dateStarted +
//                ", dateEnded=" + dateEnded +
//                '}';
//    }
//    /* end toString */
//
//}
