package randyowens.seniorproject.entity;

import jakarta.persistence.*;

@Entity
@Table( name="user" )
public class User {

    // define fields
    // User: user_id, name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column
    private String name;

    // no-arg constructor
    public User() {

    }

    // default constructor
    public User(String name) {
        this.name = name;
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
    /* end getters & setters */


    /* define toString */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
    /* end toString */

}
