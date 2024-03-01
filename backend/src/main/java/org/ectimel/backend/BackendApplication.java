package org.ectimel.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		System.out.println("Hello Diet Generator");
		SpringApplication.run(BackendApplication.class, args);
	}

}
