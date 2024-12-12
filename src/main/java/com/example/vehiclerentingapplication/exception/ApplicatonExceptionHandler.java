package com.example.vehiclerentingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vehiclerentingapplication.util.ErrorStructure;

@RestControllerAdvice
public class ApplicatonExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "failed to find the user with the given id"));
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUploadImage(FailedToUploadImageException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "failed to upload the image "));
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleImageNotFoundById(ImageNotFoundExceptionById ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "failed to find the image with the given id"));
	}
}
