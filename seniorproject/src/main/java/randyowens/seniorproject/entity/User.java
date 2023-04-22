package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

// User Entity mapping
// Bean Validation will create table
// Email must be unique
// OneToMany mapping with

/**
 * User Entity Mapping
 * Email must be unique
 * OneToMany relationship with Read entity
 * Bean Validation @ create table
 */

@Entity
@Table( name="user",
        uniqueConstraints = {
            @UniqueConstraint( columnNames = "email")
        })
public class User {

    // define fields
    // user: user_id, username, password, email, date_created, reads

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "user_id" )
    private Long userId;

    @Column( name = "username" )
    @NotBlank
    @Size( min = 5, max = 20)
    private String username;

    @Column( name = "password" )
    @NotBlank
    @Size( min = 5, max = 20)
    private String password;

    @Column( name = "email" )
    @NotBlank
    @Email
    private String email;

    @Column( name = "date_created" )
    private java.util.Date dateCreated;

    // List over Set for easy ordering ?
    @OneToMany( mappedBy = "user" )
    private List<Read> reads;

   // no-arg constructor
    public User() {

    }

    // default constructor
    public User(String username, String password, String email, Date dateCreated) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreated = dateCreated;
    }


    /* define getters & setters */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Read> getReads() {
        return reads;
    }
    public void setReads(List<Read> reads) {
        this.reads = reads;
    }
    /* end getters & setters */


    /* define toString */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                ", reads=" + reads +
                '}';
    }
    /* end toString */

}
