package com.hoaxify.ws.auth;




import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.user.IUserRepository;
import com.hoaxify.ws.user.User;


@RestController
public class AuthController {
	@Autowired
	IUserRepository userRepository;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	
	@PostMapping("/api/1.0/auth")
	 ResponseEntity<?> handleAuthentication(@RequestHeader(name="Authorization", required = false) String authorization)  {
		if(authorization == null) {
			ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		String base64encoded = authorization.split(" ")[1];
		System.out.println(base64encoded);
		String decoded = new String(Base64.getDecoder().decode(base64encoded));
		String[] parts = decoded.split(":");
		String userName = parts[0];
		String password = parts[1];
		
		User inDb = userRepository.findByUserName(userName);
		if(inDb == null ) {
			ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		String hashedPassword = inDb.getPassword();
		if(!passwordEncoder.matches(password, hashedPassword)) {
			ApiError error = new ApiError(401, "Unauthorized request", "/api/1.0/auth");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
		}
		return ResponseEntity.ok().build();
	}
	
}
