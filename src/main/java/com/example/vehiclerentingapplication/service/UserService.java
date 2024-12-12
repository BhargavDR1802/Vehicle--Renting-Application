package com.example.vehiclerentingapplication.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.mapper.UserMapper;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.request.UserRequest;
import com.example.vehiclerentingapplication.response.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final UserMapper mapper;

	public UserService(UserRepository userRepository, UserMapper mapper) {
		super();
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	public UserResponse saveUser(UserRequest userRequest) {
		User user = mapper.mapToUser(userRequest);
		User savedUser = userRepository.save(user);
		return mapper.mapToResponse(savedUser);
	}

}