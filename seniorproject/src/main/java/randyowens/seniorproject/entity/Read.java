package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table( name = "user_reads")
public class Read {

    // define fields
    // Reads: read_id, google_id, read_state, user_id, total_pages
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
    private ReadStateEnum readState;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id", referencedColumnName = "user_id")
    private UserAccount user;

    @Column( name = "total_pages")
    private Integer totalPages;


    // no arg constructor
    public Read() {

    }

    // default constructor
    public Read(String googleBookId, ReadStateEnum readState, Integer totalPages) {
        this.googleBookId = googleBookId;
        this.readState = readState;
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

    public Integer getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(Integer totalPages) { this.totalPages = totalPages; }

    public ReadStateEnum getReadState() { return readState; }
    public void setReadState(ReadStateEnum readState) { this.readState = readState; }

    public UserAccount getUser() { return this.user; }
    public void setUser(UserAccount user) { this.user = user; }
    /* end getters & setters */

    /* define toString */
    @Override
    public String toString() {
        return "Read{" +
                "readId=" + readId +
                ", googleBookId='" + googleBookId + '\'' +
                ", readState=" + readState +
                ", userAccount=" + user +
                ", totalPages=" + totalPages +
                '}';
    }
    /* end toString */

}
