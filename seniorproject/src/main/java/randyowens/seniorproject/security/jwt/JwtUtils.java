package randyowens.seniorproject.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import randyowens.seniorproject.security.services.UserDetailsImpl;

import java.util.Date;

/**
 * Create JWT & parse JWT
 * @generateJwtToken(Authentication authentication)
 * @getUserNameFromJwtToken(String token)
 * @validateJwtToken(String authToken)
 */

@Component
public class JwtUtils {

    // env property
    @Value("${senior-project.app.jwtSecret}")
    private String jwtAccessKey;

    // Valid log in token for 24 hours - milliseconds
    private int jwtAccessTime = 86400000;

    /**
     * Build JWT Token for User Access
     * @param authentication
     * @return JWT Token
     */
    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl user = null;

        try {
            user = (UserDetailsImpl) authentication.getPrincipal();

        } catch (Exception e) {
            System.out.println("\n---Username was not found for token to generate.---");
            System.out.println(e);
            System.out.println();
        }

        // Builder user token on username, issue time, expire time, hash
        return Jwts.builder()
                .setSubject((user.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtAccessTime))
                .signWith(SignatureAlgorithm.HS512, jwtAccessKey)
                .compact();
    }

    /**
     * Parse JWT Token for User username
     * @param token
     * @return username value from User
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtAccessKey).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validate JWT Token for authenticity
     * @param authToken
     * @return t/f
     */
    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().setSigningKey(jwtAccessKey).parseClaimsJws(authToken);
            return true;

        } catch (MalformedJwtException e) {
            System.out.println("---JWT Token Invalid---");
            System.out.println(e.getMessage());

        } catch (ExpiredJwtException e) {
            System.out.println("---JWT Token Expired---");
            System.out.println(e.getMessage());

        } catch (UnsupportedJwtException e) {
            System.out.println("---JWT Token Incorrect Format---");
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("---JWT received is null---");
            System.out.println(e.getMessage());

        }

        return false;

    }

}
