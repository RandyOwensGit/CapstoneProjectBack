package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import randyowens.seniorproject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Interface for simple data methods

    /** Link to JpaRepository methods
     * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
     */

}
