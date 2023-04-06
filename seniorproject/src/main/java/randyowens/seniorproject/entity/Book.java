package randyowens.seniorproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    // define fields
    // Book: book_id, user_id, title, description, pages, picture

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "pages")
    private int pages;

    @Lob
    @Column(name = "picture", length = 1000)
    private byte[] imageData;



}
