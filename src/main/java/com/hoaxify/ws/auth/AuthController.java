package com.hoaxify.ws.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.hoaxify.ws.shared.CurrentUser;
import com.hoaxify.ws.shared.Views;
import com.hoaxify.ws.user.IUserRepository;
import com.hoaxify.ws.user.User;


@RestController
public class AuthController {
	@Autowired
	IUserRepository userRepository;
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class)
	 ResponseEntity<?> handleAuthentication(@CurrentUser User user)  {
		return ResponseEntity.ok(user);
	}
}
