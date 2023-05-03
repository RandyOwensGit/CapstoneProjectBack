package randyowens.seniorproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Testion database relationship mapping with Course Entity Class
 */

@Entity
@Table( name = "Courses" )
public class Course {

    // define fields
    // course_id, course_name, course_hours, studentsList

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "course_id" )
    private Long courseId;

    @Column( name = "course_name" )
    private String courseName;

    @Column( name = "course_hours" )
    private Integer courseHours;

    @JsonIgnore
    @OneToMany( mappedBy = "course", cascade = CascadeType.ALL )
    //@JsonBackReference
    private Set<Student> students = new HashSet<>();

    public Course() {

    }

    public Course(String courseName, int courseHours, Set<Student> students) {
        this.courseName = courseName;
        this.courseHours = courseHours;
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(int courseHours) {
        this.courseHours = courseHours;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseHours=" + courseHours +
                '}';
    }
}
