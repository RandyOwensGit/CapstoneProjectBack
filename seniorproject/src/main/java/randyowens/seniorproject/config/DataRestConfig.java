package randyowens.seniorproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import randyowens.seniorproject.entity.Test;

/**
 * Configuration File for Data Rest framework
 */

@ConfigurationProperties
public class DataRestConfig implements RepositoryRestConfigurer {

    // frontend links to be allowed
    private String[] allowed = {"https://senior-project-front.onrender.com/", "https://randyowens.me/", "https://www.randyowens.me/"};

    // Configure -- accessing API sites need the cors to be configured
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // CURRENTLY -- ALL HTTP METHODS ALLOWED ON ANY ENTITY
        HttpMethod[] unsupportedMethods = {
                HttpMethod.DELETE,
                HttpMethod.PUT,
                HttpMethod.PATCH
        };

        // gather endpoints from Test
        config.exposeIdsFor(Test.class);

        // disable unsupportedMethods for HTTP
        disableHttpMethods(Test.class, config, unsupportedMethods);

        // CORS mapping configuration
        cors.addMapping("/**").allowedOrigins("*").allowedMethods("*");
        cors.addMapping("/**").allowedOrigins("*").allowedMethods("*");
        cors.addMapping("/**").allowedOrigins("*").allowedMethods("*");

    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedMethods) {
        // disable HTTP methods for Tests class
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedMethods));
    }
}
