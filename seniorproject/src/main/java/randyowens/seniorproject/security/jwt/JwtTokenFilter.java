package randyowens.seniorproject.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import randyowens.seniorproject.security.services.UserDetailsServiceImpl;

import java.io.IOException;

/**
 * Filter that runs on every request
 * Validates the header token from front-end
 * Extends OncePerRequestFilter
 * @doFilterInternal
 * @parseJwt
 */

public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Validate Request Token
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            // compare token
            String jwtToken = parseJwt(request);

            // check for username and retrieve it
            if((jwtToken != null) && (jwtUtils.validateJwtToken(jwtToken))) {

                String username = jwtUtils.getUserNameFromJwtToken(jwtToken);

                // Authenticate user with user details and validate token response
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken userJwtToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // assign details to token
                userJwtToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // apply the user token to create 'session'
                SecurityContextHolder.getContext().setAuthentication(userJwtToken);
            }

        } catch (Exception e) {
            System.out.println("\nAuthentication Failed: " + e);
        }

        filterChain.doFilter(request, response);

    }

    /**
     * Check there is a header with Bearer Token
     * @param httpRequest
     * @return JWT Token String
     */
    private String parseJwt(HttpServletRequest httpRequest) {
        String readableHeader = httpRequest.getHeader("Authorization");

        if(StringUtils.hasText(readableHeader) && readableHeader.startsWith("Bearer ")) {
            return readableHeader.substring(7, readableHeader.length());
        }

        return null;
    }

}
