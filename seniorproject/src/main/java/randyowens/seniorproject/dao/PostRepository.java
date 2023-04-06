package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import randyowens.seniorproject.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

    // Interface for simple data methods

    /** Link to JpaRepository methods
     * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
     */


}
