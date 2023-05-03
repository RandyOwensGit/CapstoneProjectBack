package randyowens.seniorproject.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import randyowens.seniorproject.dao.RoleRepository;
import randyowens.seniorproject.dao.UserRepository;
import randyowens.seniorproject.entity.UserAccount;
import randyowens.seniorproject.payload.request.RequestRegister;
import randyowens.seniorproject.utils.RoleEnum;
import randyowens.seniorproject.entity.Role;
import randyowens.seniorproject.payload.request.RequestLogin;
import randyowens.seniorproject.payload.response.JwtResponse;
import randyowens.seniorproject.payload.response.ResponseMessage;
import randyowens.seniorproject.security.jwt.JwtUtils;
import randyowens.seniorproject.security.services.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * Rest endpoint handling for
 * /api/auth/signin
 * /api/augh/signup
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    /**
     * Client login request
     * @param loginRequest
     * @return User Entity
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody RequestLogin loginRequest) {
        // Map Request params to the RequestLogin Class Entity

        // validate username and password
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch(Exception e) {
            System.out.println("Username not found for request. : " + e);
        }

        // generate token for user login
        String jwt = jwtUtils.generateJwtToken(authentication);

        // get the allowed permissions (currently nothing but user)
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Map the roles user has -- in this case just user, nothing else exists yet
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        // build the ResponseEntity mapping to return
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getDateCreated(),
                roles));
    }

    /**
     * Client register request
     * @param requestRegister
     * @return User Entity
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RequestRegister requestRegister) {
        // Map Request params to the RequestRegister Class Entity

        // Check if user already exists by email - since they must be unique
        if (userRepository.existsByEmail(requestRegister.getEmail())) {
            return ResponseEntity.badRequest().body(
                    new ResponseMessage("Register Error: Email already exists.")
            );
        }

        // Create new user's account
        UserAccount user = new UserAccount(
                requestRegister.getUsername(),
                encoder.encode(requestRegister.getPassword()),
                requestRegister.getEmail()
        );

        // Build Role Set with just ROLE_USER
        Set<Role> roles = new HashSet<>();

        // get role from roles table
        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER).orElseThrow(
                () -> new RuntimeException("Role USER not found")
        );

        // assign role to user
        roles.add(userRole);
        user.setRoles(roles);

        // save new user
        userRepository.save(user);

        // HTTP response message
        return ResponseEntity.ok(new ResponseMessage("User Registered"));
    }

}
