
package com.example.vehiclerentingapplication.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.service.ImageService;
import com.example.vehiclerentingapplication.util.SimpleResponseStructure;

@RestController
public class ImageController {
	private final ImageService imageService;

	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}

	@PostMapping("/users/add-profile-picture")
	public ResponseEntity<SimpleResponseStructure> addProfilePicture(@RequestParam("file") MultipartFile file)
			throws IOException {
		imageService.uploadUserProfilePicture(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(SimpleResponseStructure.create(HttpStatus.OK.value(), "Profile picture added successfully"));
	}

	@GetMapping("/users/get-profile-picture")
	public ResponseEntity<byte[]> getProfilePicture() {
		Image image = imageService.findImageByCurrentUser();
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf(image.getContentType()))
				.body(image.getImageBytes());
	}
	@PostMapping("/users/vehicle-picture")
	public ResponseEntity<SimpleResponseStructure> uploadVehicleImages(@RequestParam("file") List<MultipartFile> file,@RequestParam("vehicleId") int vehicleId)
			throws IOException {
		imageService.uploadVehicleImages(file,vehicleId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(SimpleResponseStructure.create(HttpStatus.OK.value(), "Vehicle picture added successfully"));
	}
}
