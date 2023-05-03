package randyowens.seniorproject.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

/**
 * Testion database relationship mapping with Course Entity Class
 */

@Entity
@Table( name = "Students" )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    // define fields
    // student_id, first_name, last_name, age

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "student_id" )
    private Long studentId;

    @Column( name = "first_name" )
    private String firstName;

    @Column( name = "last_name" )
    private String lastName;

    @Column( name = "age" )
    private Integer age;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "course_id", referencedColumnName = "course_id" )
    //@JsonManagedReference
    private Course course;

    // required empty constructor
    public Student() {

    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Course getCourse() {
        return course;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
