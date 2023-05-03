package randyowens.seniorproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import randyowens.seniorproject.security.jwt.JwtTokenFilter;
import randyowens.seniorproject.security.jwt.JwtAuthenticationEntryPoint;
import randyowens.seniorproject.security.services.UserDetailsServiceImpl;

/**
 * Spring Security Configuration File
 * Dependency Injection for Beans
 * @Method
 */
// with @EnableMethodSecurity over @EnableGlobalMethodSecurity (Deprecated)
// prePostEnabled is by default true
@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    // access user details to run authorization on
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtTokenFilter authenticationJwtTokenFilter() {
        return new JwtTokenFilter();
    }

    /**
     * Provides valid user details
     * @return DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Encrypt Injector
     * @return Valid PasswordEncoder Object
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Security on Endpoints
     * @param http
     * @return HTTP Request
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests().requestMatchers("/api/user/**").permitAll()
                .requestMatchers("/api/tests/**").permitAll()
                .requestMatchers("/api/reads").permitAll()
                .requestMatchers("/api/reads/").permitAll()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/api**").permitAll()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/api/courses/**").permitAll()
                .anyRequest().authenticated();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }









}
