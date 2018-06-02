package edu.mum.exercise_8.B;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("edu.mum.exercise_8.B")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
