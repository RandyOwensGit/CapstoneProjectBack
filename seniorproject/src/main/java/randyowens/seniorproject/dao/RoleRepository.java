package randyowens.seniorproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import randyowens.seniorproject.utils.RoleEnum;
import randyowens.seniorproject.entity.Role;

import java.util.Optional;

/**
 * Get Role
 * @findByName
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

    // Find role
    Optional<Role> findByName(RoleEnum name);

}
