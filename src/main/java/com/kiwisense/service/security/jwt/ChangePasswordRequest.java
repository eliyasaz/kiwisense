package com.kiwisense.service.security.jwt;

import javax.validation.constraints.NotBlank;

public class ChangePasswordRequest extends LoginRequest {
	@NotBlank
	private String confirPassword;

	public String getConfirPassword() {
		return confirPassword;
	}

	public void setConfirPassword(String confirPassword) {
		this.confirPassword = confirPassword;
	}


}
