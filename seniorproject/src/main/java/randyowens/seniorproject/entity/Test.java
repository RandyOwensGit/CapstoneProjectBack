package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import randyowens.seniorproject.utils.ReadStateEnum;

import java.util.Date;

@Entity
@Table(name = "test_table")
public class Test {

    // Table for Testing Live Project
    // test_table: test_id, test_name, title, read_state(enum), created_date

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "test_id" )
    private int testId;

    @Column( name = "test_name" )
    private String name;

    @Column( name = "title" )
    private String title;

    @Column( name = "read_state" )
    @Enumerated( EnumType.STRING )
    private ReadStateEnum readState;

    @Column( name = "created_date" )
    @CreationTimestamp
    private java.util.Date createdDate;

    // Required no arg constructor
    public Test () {

    }

    // Arg constructor
    public Test(String name, String title, ReadStateEnum readState, Date createdDate) {
        this.name = name;
        this.title = title;
        this.readState = readState;
        this.createdDate = createdDate;
    }

    // getters and setters

    public int getTestId() {
        return testId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public ReadStateEnum getReadState() {
        return readState;
    }
    public void setReadState(ReadStateEnum readState) {
        this.readState = readState;
    }

    public Date getDateStarted() {
        return createdDate;
    }
    public void setDateStarted(Date dateStarted) {
        this.createdDate = dateStarted;
    }

    // toString
    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", readState='" + readState + '\'' +
                ", dateStarted=" + createdDate +
                '}';
    }
}
