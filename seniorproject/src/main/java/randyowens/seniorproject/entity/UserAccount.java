package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table( name="user_account",
        uniqueConstraints = {
            @UniqueConstraint( columnNames = "email")
        })
public class UserAccount {

    // define fields
    // user: user_id, username, password, email, date_created, roles

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "user_id" )
    private Long userId;

    @Column( name = "username" )
    @NotBlank
    @Size( min = 5, max = 50)
    private String username;

    @Column( name = "password" )
    @NotBlank
    @Size( max = 120 )
    private String password;

    @Column( name = "email")
    @NotBlank
    @Size( max = 100)
    @Email
    private String email;

    // user roles (only user role)
    // Set for no duplicates
    @ManyToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "user_roles",
                joinColumns = @JoinColumn( name = "user_id" ),
                inverseJoinColumns = @JoinColumn( name = "role_id" ))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL )
    private Set<Read> reads = new HashSet<>();

    @Column( name = "date_created" )
    @CreationTimestamp
    private java.util.Date createdDate;

   // no-arg constructor
    public UserAccount() {

    }

    // default constructor
    public UserAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public Date getDate() {
        return this.createdDate;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Read> getReads() {
        return this.reads;
    }
    public void setReads(Set<Read> reads) {
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
                ", dateCreated=" + createdDate +
                '}';
    }
    /* end toString */

}
