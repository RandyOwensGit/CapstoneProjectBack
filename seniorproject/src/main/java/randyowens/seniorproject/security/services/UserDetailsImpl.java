package randyowens.seniorproject.security.services;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import randyowens.seniorproject.entity.Read;
import randyowens.seniorproject.entity.UserAccount;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implement Spring Security UserDetails
 * Object to hold User
 */

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    private Date dateCreated;

    private List<Read> reads;

    // avoid mapping to JSON content
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public UserDetailsImpl(
            Long id,
            String username,
            String email,
            String password,
            Date dateCreated,
            List<Read> reads,
            Collection<? extends GrantedAuthority> grantedAuthorities
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.reads = reads;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static UserDetailsImpl build(UserAccount user) {
        // create List of GrantedAuthority for each user roles
        List<GrantedAuthority> grantedAuthorityList = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getDate(),
                user.getReads(),
                grantedAuthorityList
        );
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<Read> getReads() {
        return this.reads;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
