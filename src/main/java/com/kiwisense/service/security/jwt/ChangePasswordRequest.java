package com.kiwisense.service.security.jwt;

import javax.validation.constraints.NotBlank;

public class ChangePasswordRequest extends LoginRequest {
	@NotBlank
	private String newPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	

}
