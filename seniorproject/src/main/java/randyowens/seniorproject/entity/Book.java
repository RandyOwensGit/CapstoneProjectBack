package randyowens.seniorproject.entity;

import jakarta.persistence.*;

import java.util.Arrays;

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
    private User userId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "pages")
    private int pages;

    @Lob
    @Column(name = "picture", length = 1000)
    private byte[] imageData;

    // require no-arg constructor
    public Book() {

    }

    // full arg constructor
    public Book(User userId, String title, String description, int pages, byte[] imageData) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.pages = pages;
        this.imageData = imageData;
    }

    /* define getters & setters */
    public int getBookId() {
        return bookId;
    }

    public User getUser() {
        return userId;
    }
    public void setUser(User user) {
        this.userId = user;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public byte[] getImageData() {
        return imageData;
    }
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
    /* end getters & setters */

    /* define toString */
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }
    /* end toString */
}
