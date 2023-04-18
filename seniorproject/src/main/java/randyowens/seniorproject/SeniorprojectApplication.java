package randyowens.seniorproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SeniorprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeniorprojectApplication.class, args);
	}

	@GetMapping("count-users")
	public String getCountUsers() {
		return "Hello Render with Spring Boot";
	}

}
