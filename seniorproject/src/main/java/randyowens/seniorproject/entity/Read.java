package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import randyowens.seniorproject.utils.ReadStateEnum;

import java.util.Date;

// Represents User adding read books
// No unique identifier because multiple users may add the same book

/**
 * Read Entity Mapping - Each book added by user
 * 'Many' reads map to 'one' user
 * ManyToOne mapping to user
 * Bean Validation @ create table
 */

@Entity
@Table( name = "read")
public class Read {

    // define fields
    // Reads: read_id, google_id, read_state, date_started, date_ended, user_id
    // enum values not_reading, reading, finished

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "read_id" )
    private Long readId;

    @Column( name = "google_id" )
    @NotBlank
    private String googleBookId;

    @Column( name = "read_state" )
    @Enumerated(EnumType.ORDINAL)
    @NotBlank
    private ReadStateEnum readState;

    @Column( name = "date_started" )
    private java.util.Date dateStarted;

    @Column( name = "date_ended" )
    private java.util.Date dateEnded;

    @ManyToOne
    @JoinColumn( name = "user_id", nullable = false )
    User user;


    // no arg constructor
    public Read() {

    }

    // default constructor
    public Read(String googleBookId, ReadStateEnum readState, Date dateStarted, Date dateEnded, User user) {
        this.googleBookId = googleBookId;
        this.readState = readState;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.user = user;
    }


    /* define getters & setters */
    public Long getReadId() {
        return readId;
    }
    public void setReadId(Long readId) { this.readId = readId; }

    public String getGoogleBookId() {
        return googleBookId;
    }
    public void setGoogleBookId(String googleBookId) { this.googleBookId = googleBookId; }

    public ReadStateEnum getReadState() { return readState; }
    public void setReadState(ReadStateEnum readState) { this.readState = readState; }

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

    public User getUser() { return this.user; }
    public void setUser(User user) { this.user = user; }
    /* end getters & setters */

    /* define toString */

    @Override
    public String toString() {
        return "Read{" +
                "readId=" + readId +
                ", googleBookId='" + googleBookId + '\'' +
                ", readState=" + readState +
                ", dateStarted=" + dateStarted +
                ", dateEnded=" + dateEnded +
                ", user=" + user +
                '}';
    }
    /* end toString */

}
