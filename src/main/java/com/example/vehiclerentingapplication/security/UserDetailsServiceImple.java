package com.example.vehiclerentingapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.repository.UserRepository;

@Service
public class UserDetailsServiceImple implements UserDetailsService{

	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImple(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);

		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		return userDetailsImpl;
	}
}