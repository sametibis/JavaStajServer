package com.hoaxify.ws.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	IUserRepository userRepository;
	PasswordEncoder passwordEncoder;
	
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository; // IUserRepository üzeindeki @Autowired ile eşdeğer.
		this.passwordEncoder = new BCryptPasswordEncoder();
	} 
	
	public void save(User user) {
		String encryptedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepository.save(user);
		
	}
	
}
