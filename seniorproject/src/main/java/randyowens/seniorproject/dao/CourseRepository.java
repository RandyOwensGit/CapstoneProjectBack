package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import randyowens.seniorproject.entity.Course;

@CrossOrigin(origins = "*", maxAge = 3600)
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {



}
