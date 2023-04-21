package randyowens.seniorproject.security.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import randyowens.seniorproject.dao.UserAuthRepository;
import randyowens.seniorproject.entity.UserAuth;

import java.io.Serial;

/**
 * Implement Spring Security UserDetailsService
 * Retrieve full User information from repository
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(userAuth);
    }

}
