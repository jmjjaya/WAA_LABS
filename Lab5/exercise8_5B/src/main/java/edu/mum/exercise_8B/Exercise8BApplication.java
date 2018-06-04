package edu.mum.exercise_8B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan("edu.mum.exercise_8B")
public class Exercise8BApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exercise8BApplication.class, args);
	}
}
