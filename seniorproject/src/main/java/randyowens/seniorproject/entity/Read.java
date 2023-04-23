package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Type;
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
@Table( name = "reads")
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
    @Enumerated( EnumType.STRING )
    @NotBlank
    private ReadStateEnum readState;

    @Column( name = "pages_read" )
    private int pagesRead;

    @Column( name = "total_pages")
    @NotBlank
    private int totalPages;

    @Column( name = "date_started" )
    private java.util.Date dateStarted;

    @Column( name = "date_ended" )
    private java.util.Date dateEnded;

    @ManyToOne
    @NotBlank
    @JoinColumn( name = "user_id" )
    UserAccount userId;

    // no arg constructor
    public Read() {

    }

    // default constructor
    public Read(String googleBookId, ReadStateEnum readState, Date dateStarted, Date dateEnded, UserAccount user, int pagesRead, int totalPages) {
        this.googleBookId = googleBookId;
        this.readState = readState;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.userId = user;
        this.pagesRead = pagesRead;
        this.totalPages = totalPages;
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

    public int getPagesRead() {
        return pagesRead;
    }
    public void setPagesRead(int pagesRead) { this.pagesRead = pagesRead; }

    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }

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

    public UserAccount getUser() { return this.userId; }
    public void setUser(UserAccount user) { this.userId = user; }
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
                ", user=" + userId +
                '}';
    }
    /* end toString */

}
