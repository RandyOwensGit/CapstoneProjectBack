package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import randyowens.seniorproject.entity.Student;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByCourse(Integer courseId);

}
