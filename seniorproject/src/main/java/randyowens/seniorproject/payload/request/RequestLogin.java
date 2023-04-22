package randyowens.seniorproject.payload.request;

import jakarta.validation.constraints.NotBlank;

/**
 * Entity mapping required for signing up
 */
public class RequestLogin {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}