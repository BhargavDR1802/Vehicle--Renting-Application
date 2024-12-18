package com.example.vehiclerentingapplication.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.enums.UserRole;
import com.example.vehiclerentingapplication.mapper.UserMapper;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.request.UserRequest;
import com.example.vehiclerentingapplication.response.UserResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper mapper;

	private final PasswordEncoder passwordEncoder;

	private final AuthUtil authUtil;


	public UserService(UserRepository userRepository, UserMapper mapper, PasswordEncoder passwordEncoder,AuthUtil authUtil) {
		super();
		this.userRepository = userRepository;
		this.mapper = mapper;
		this.passwordEncoder = passwordEncoder;
		this.authUtil = authUtil;
	}
	public UserResponse register(UserRequest userRequest, UserRole userRole) {
		User user = mapper.mapToUser(userRequest, new User());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(userRole); 
		user = userRepository.save(user);
		return mapper.mapToResponse(user);
	}


	public UserResponse account()
	{
		//		User user = userRepository.findById(userId)
		//				.orElseThrow(() -> new UserNotFoundByIdException("User Not Found By ID"));
		User user = authUtil.getCurrentUser();
		UserResponse userResponse = mapper.mapToResponse(user);

		Integer profilePictureId = userRepository.findImageById(user.getUserId());

		if(profilePictureId!=null)
		{
			userResponse.setProfilePictureLink("/find/imageById?imageId="+profilePictureId);
		}
		else
		{
			userResponse.setProfilePictureLink(null);	
		}
		return userResponse;
	}


	public UserResponse updateUserById(UserRequest userRequest) {
		//	    User existingUser = userRepository.findById(userId)
		//	            .orElseThrow(() -> new UserNotFoundByIdException("User Not Found By ID: " + userId));
		User updatedUser = mapper.mapToUser(userRequest, authUtil.getCurrentUser());
		updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
		updatedUser = userRepository.save(updatedUser);
		return mapper.mapToResponse(updatedUser);
	}





}