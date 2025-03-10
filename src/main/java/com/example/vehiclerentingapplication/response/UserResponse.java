package com.example.vehiclerentingapplication.response;

import com.example.vehiclerentingapplication.enums.UserRole;

public class UserResponse
{
	private int userId;

	private String username;

	private String phoneNumber;

	private String email;

	private UserRole role;
	
	private String profilePictureLink;

	

	public String getProfilePictureLink() {
		return profilePictureLink;
	}

	public void setProfilePictureLink(String profilePictureLink) {
		this.profilePictureLink = profilePictureLink;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}
