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

}
