package com.example.vehiclerentingapplication.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.ImageNotFoundByIdException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;

@Service
public class ImageService {

	private final ImageRepository imageRepository;

	private final UserRepository userRepository;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
	}

	public void addUserProfilePicture(int userId, MultipartFile multipartFile) {

		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {
			User user = optional.get();
			Image exImage = user.getProfilePicture();
			
			Image image = getImage(multipartFile);
			image = imageRepository.save(image);

			user.setProfilePicture(image);
			userRepository.save(user);
			
			if(exImage != null)
			{
				imageRepository.delete(exImage);
			}
		} else {
			throw new UserNotFoundByIdException("Failed to Find the user");
		}
	}

	private Image getImage(MultipartFile imagefile) {
		Image image = new Image();
		try {
			byte[] imageBytes = imagefile.getBytes();
			image.setContentType(imagefile.getContentType());
			image.setImageBytes(imageBytes);
		} catch (IOException e) {
			throw new FailedToUploadImageException("Failed to upload the Image");
		}

		return image;
	}
	
	public Image findImageById(int imageId) {
		Optional<Image> optional = imageRepository.findById(imageId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			throw new ImageNotFoundByIdException("failed to find image by given id");
		}
	}
}
