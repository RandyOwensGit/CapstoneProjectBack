package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import randyowens.seniorproject.entity.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

    // Interface for simple data methods

    /** Link to JpaRepository methods
     * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
     */

}
