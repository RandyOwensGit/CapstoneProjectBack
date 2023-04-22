package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import randyowens.seniorproject.entity.User;

import java.util.Optional;

/**
 * Methods to run on DAO User
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Link to JpaRepository methods included with spring data rest
    // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html


    Optional<Object> findByUsername(String username);


}
