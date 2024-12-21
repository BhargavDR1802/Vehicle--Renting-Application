package com.example.vehiclerentingapplication.exception;

import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vehiclerentingapplication.util.ErrorStructure;

@RestControllerAdvice
public class ApplicatonExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundByIdException(UserNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed To Find The User With Ghe Given Id"));
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleFailedToUploadImageException(FailedToUploadImageException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Failed To Upload The Image "));
	}

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleImageNotFoundByIdException(ImageNotFoundByIdException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed To Find Ihe Image With The Given Id"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleVehicleNotFoundByIdException(VehicleNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed To Find The Vehicle With The Given Id"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUsernameNotFoundException(UsernameNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed To Find The Given Username"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleLocationNotFoundException(LocationNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), "Failed To Find The Location"));
		}
}
