package com.hoaxify.ws.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericResponse;

@RestController
public class UserController {
	
	@Autowired // DependecyInjection
	UserService userService;
	
	
	@PostMapping("/api//1.0/users")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> createUser(@RequestBody User user) {
		
		ApiError error = new ApiError(400, "Validation Error", "/api/1.0/users");
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		String userName = user.getUserName();
		String displayName = user.getDisplayName();

		if(userName == null || userName.isEmpty()) {
			validationErrors.put("userName", "User name can not be null.");
		}
		
		if(displayName == null || displayName.isEmpty()) {
			validationErrors.put("displayName", "Display name can not be null.");
		}
		if(validationErrors.size() > 0) {
			error.setValidationError(validationErrors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		
		userService.save(user);
		GenericResponse response = new GenericResponse();
		response.setMessage("User created: " + user);
		return ResponseEntity.ok(response);
		
	}
}
