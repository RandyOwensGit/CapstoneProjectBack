package randyowens.seniorproject.payload.response;

import randyowens.seniorproject.entity.Read;

import java.util.Date;
import java.util.List;

/**
 * Body of HTTP Response
 * 'Array' of values with JSON
 * Everything to be returned to JWT request gets included here
 */
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private Date dateCreated;
    private List<String> roles;

    public JwtResponse(
            String accessToken,
            Long id,
            String username,
            String email,
            Date dateCreated,
            List<String> roles
    ) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.dateCreated = dateCreated;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<String> getRoles() {
        return roles;
    }

}
