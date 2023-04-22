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

public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            //
            String jwt = parseJwt(request);

            // check for username and retrieve it
            if(jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);

                // Assign  user details to gather the information from database
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // build a token for this user's current session
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // apply the user token to create a session
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
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
