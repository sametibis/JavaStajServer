package com.hoaxify.ws.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	IUserRepository userRepository;
	
	public UserService(IUserRepository userRepository) {
		this.userRepository = userRepository;
	} // IUserRepository üzeindeki @Autowired ile eşdeğer.



	public void save(User user) {
		userRepository.save(user);
		
	}
	
}
