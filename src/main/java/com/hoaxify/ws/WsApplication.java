package com.hoaxify.ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WsApplication {

	public static void main(String[] args) {
		// Test Comment
		SpringApplication.run(WsApplication.class, args);
	}
	
	// Create a initial user 
	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
				User user = new User("user1", "display1", "Password1");
				userService.save(user);
			};
	};
}
