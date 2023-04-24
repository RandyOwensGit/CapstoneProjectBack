package randyowens.seniorproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Application
 * @Return Runs Application
 */
@SpringBootApplication
public class SeniorprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeniorprojectApplication.class, args);
	}

}
