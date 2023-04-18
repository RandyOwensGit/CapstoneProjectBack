package randyowens.seniorproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import randyowens.seniorproject.entity.Test;

/**
 * Configuration File for Data Rest framework
 */

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    // Needs to be updated when project is hosted on Render.com
    private String allowed = "http://localhost:3000";

    // Configure -- accessing API sites need the cors to be configured
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // CURRENTLY -- ALL HTTP METHODS ALLOWED ON ANY ENTITY

        // CORS mapping configuration
        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(allowed);

    }
}
