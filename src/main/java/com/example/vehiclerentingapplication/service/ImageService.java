
package com.example.vehiclerentingapplication.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.ImageNotFoundByIdException;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.security.AuthUtil;

@Service
public class ImageService {

	private final ImageRepository imageRepository;
	private final UserRepository userRepository;
	private final VehicleRepository vehicleRepository;
	private final AuthUtil authUtil;

	public ImageService(ImageRepository imageRepository, UserRepository userRepository,
			VehicleRepository vehicleRepository, AuthUtil authUtil) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository = userRepository;
		this.vehicleRepository = vehicleRepository;
		this.authUtil = authUtil;
	}

	public void uploadUserProfilePicture(MultipartFile file) {
		User user = authUtil.getCurrentUser();

		Image oldImage = user.getProfilePicture();
		if (oldImage != null) {
			imageRepository.delete(oldImage);
		}

		Image newImage = saveImage(file);
		user.setProfilePicture(newImage);
		userRepository.save(user);
	}

	public Image findImageByCurrentUser() {
		User user = authUtil.getCurrentUser();
		Image image = user.getProfilePicture();
		if (image == null) {
			throw new ImageNotFoundByIdException("No profile picture found for the current user");
		}
		return image;
	}

	private List<Image>  saveImage(List<MultipartFile> file) {
		List<Image> images = new ArrayList<Image>();
		for(MultipartFile files : file)
		{
			try {
				Image image = new Image();
				image.setContentType(files.getContentType());
				image.setImageBytes(files.getBytes());
				images.add(imageRepository.save(image));
			} catch (IOException e) {
				throw new FailedToUploadImageException("Failed to upload the image");
			}
		}
		return images;

	}

	public void uploadVehicleImages(List<MultipartFile> vehicleImages, int vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new VehicleNotFoundException("vehicle not found"));
		List<Image> images = saveImage(vehicleImages);
		vehicle.getVehicleImages().addAll(images);
		vehicleRepository.save(vehicle);
	}
	public Image saveImage(MultipartFile file) {
		try {
			Image image = new Image();
			image.setContentType(file.getContentType());
			image.setImageBytes(file.getBytes());
			return imageRepository.save(image);
		}
		catch (IOException e) {
			throw new FailedToUploadImageException("Failed to upload Image");
		}
	}
}


