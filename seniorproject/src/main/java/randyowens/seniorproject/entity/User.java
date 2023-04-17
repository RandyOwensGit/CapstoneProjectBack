package randyowens.seniorproject.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table( name="user_table" )
public class User {

    // define fields
    // user_table: user_id, name, username, password, email, date_created,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "user_id" )
    private int userId;

    @Column( name = "name" )
    private String name;

    @Column( name = "username" )
    private String username;

    @Column( name = "password" )
    private String password;

    @Column( name = "email" )
    private String email;

    @Column( name = "date_created" )
    private java.util.Date dateCreated;

    // no-arg constructor
    public User() {

    }

    // default constructor
    public User(String name, String username, String password, String email, Date dateCreated) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateCreated = dateCreated;
    }


    /* define getters & setters */
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    /* end getters & setters */


    /* define toString */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
    /* end toString */

}
