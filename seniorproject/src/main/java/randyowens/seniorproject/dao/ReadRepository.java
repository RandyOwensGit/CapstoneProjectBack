package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import randyowens.seniorproject.entity.Read;

@CrossOrigin(origins = "*", maxAge = 3600)
@Repository
public interface ReadRepository extends JpaRepository<Read, Integer> {

    // Link to JpaRepository methods included with spring data rest
    // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

    /** Link to JpaRepository methods
     * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
     */


}
