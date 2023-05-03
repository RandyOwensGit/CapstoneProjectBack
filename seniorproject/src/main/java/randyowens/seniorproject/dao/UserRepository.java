package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import randyowens.seniorproject.entity.UserAccount;

import java.util.Optional;

/**
 * Access User DAO
 * @findByUsername
 * @existsByEmail
 * @existsByUsername
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {

    // Link to JpaRepository methods included with spring data rest
    // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html

    // DAO for User with username
    Optional<Object> findByUsername(String username);

    // Check if a User exists with particular email
    Boolean existsByEmail(String email);

    // Check if user exists with a username
    boolean existsByUsername(String username);
}
