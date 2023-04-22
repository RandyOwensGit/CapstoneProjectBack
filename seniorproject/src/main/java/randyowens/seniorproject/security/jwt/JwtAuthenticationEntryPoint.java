package randyowens.seniorproject.security.jwt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Implements AuthenticationEntryPoint
 * Used to respond when client request does not provide authorization credentials
 * @commence Handles request/response
 */

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * Error code if this class is required
     * Future Implementation with redirection
     * @param httpRequest
     * @param httpResponse
     * @param authenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpRequest, HttpServletResponse httpResponse, AuthenticationException authenticationException) throws IOException, ServletException {
        System.out.println("\nJWT Header Failed: " + authenticationException.getMessage() + "\n");

        // 401 Error - HTTP Authentication
        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "\nJwtAuthenticationEntryPoint: Unauthorized\n");
    }

}
