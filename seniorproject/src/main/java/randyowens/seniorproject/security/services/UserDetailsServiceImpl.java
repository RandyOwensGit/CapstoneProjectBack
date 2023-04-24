package randyowens.seniorproject.security.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import randyowens.seniorproject.dao.UserRepository;
import randyowens.seniorproject.entity.UserAccount;

/**
 * Implement Spring Security UserDetailsService
 * Retrieve full User information from repository
 * @return user object
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Build UserDetails Object from entity details
     * @param username
     * @return User Details Mapping Values
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = (UserAccount) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        System.out.println("\nInside UserDetailsServiceImpl userDetails(): " + UserDetailsImpl.build(user) + "\n");

        return UserDetailsImpl.build(user);
    }

}
