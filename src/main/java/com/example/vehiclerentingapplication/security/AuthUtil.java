package com.example.vehiclerentingapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.repository.UserRepository;

@Component
public class AuthUtil {

	
	public final UserRepository userRepository;

	
	@Autowired
	public AuthUtil(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public Authentication getAuthentication(){
		return SecurityContextHolder.getContext().getAuthentication();
		
	}
	
	public String getCurrentUsername(){
		
		return getAuthentication().getName();
	}
	
	public User getCurrentUser() {
		User user = userRepository.findByEmail(getCurrentUsername());
		if(user != null)
		{
			return user;
		}
		else
		{
			throw new UsernameNotFoundException("User Not Found");
		}		
	}	
}
