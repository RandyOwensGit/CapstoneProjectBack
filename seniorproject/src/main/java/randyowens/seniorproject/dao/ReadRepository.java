package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import randyowens.seniorproject.entity.Read;

public interface ReadRepository extends JpaRepository<Read, Integer> {

    // Link to JpaRepository methods included with spring data rest
    // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

    /** Link to JpaRepository methods
     * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
     */


}
