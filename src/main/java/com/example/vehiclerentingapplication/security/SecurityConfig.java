package com.example.vehiclerentingapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {	

	@Bean
	PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();

	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
	
			return http
			.csrf(csrf -> csrf.disable()) //CROSS SITE REQUEST FORGERY(ADDITIONAL SECURITY DIABLES) 
			.authorizeHttpRequests(authorize -> authorize
					.requestMatchers("/register/renting_partner","/register/customer","/register/admin","/vehicles,/locations/all")// GIVEING ACCESS TO RESOURCES THAT DONT NEED LOGGING IN
					.permitAll()
//					.requestMatchers("/vehicle/register")
//					.hasAuthority("ADMIN")
					.anyRequest()
					.authenticated())
			.formLogin(Customizer.withDefaults())//
			.build();
		
		
	}
}
