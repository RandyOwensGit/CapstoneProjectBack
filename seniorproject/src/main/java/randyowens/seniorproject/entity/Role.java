package randyowens.seniorproject.entity;

import jakarta.persistence.*;
import randyowens.seniorproject.utils.RoleEnum;

@Entity
@Table( name = "roles" )
public class Role {

    // roles: id, name,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;

    public Role() {

    }

    public Role(RoleEnum name) {
        this.name = name;
    }

    public Integer getId() {
        return role_id;
    }
    public void setId(Integer id) {
        this.role_id = id;
    }

    public RoleEnum getName() {
        return name;
    }
    public void setName(RoleEnum name) {
        this.name = name;
    }


}
