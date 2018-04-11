package com.bhaskar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhaskar.model.CustomUserDetails;
import com.bhaskar.model.User;
import com.bhaskar.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByName(username);
		
		optionalUser
		.orElseThrow(() -> new UsernameNotFoundException(" User Name Doesn't Exists"));
		
		return optionalUser
				.map(CustomUserDetails::new).get();
	}

}
