package com.hoaxify.ws.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hoaxify.ws.user.IUserRepository;
import com.hoaxify.ws.user.User;

@Service
public class UserAuthService implements UserDetailsService {
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User inDb = userRepository.findByUsername(username);
		if(inDb == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return inDb;
	}
	

}
