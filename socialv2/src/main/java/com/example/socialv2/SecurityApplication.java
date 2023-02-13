package com.example.socialv2;

import com.example.socialv2.auth.AuthenticationService;
import com.example.socialv2.auth.RegisterRequest;
import com.example.socialv2.user.UserDTO;
import com.example.socialv2.user.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}


	@Bean
	CommandLineRunner run(AuthenticationService authenticationService){
		return args -> {
			for(int i=1; i<4; i++){
				RegisterRequest request = new RegisterRequest();
				request.setPassword("1234");
				request.setName("test"+i);
				request.setEmail("test"+i);
				request.setLocation("seoul");
				request.setOccupation("test");
				request.setPicturePath("newjinss.jpg");


				authenticationService.register(request);
			}
		};
	}
}
