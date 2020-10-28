package com.kiwisense.dal.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

public class DeviceUserParameterDto {

	@NotBlank
	private String email;

	@NotBlank
	private String deviceName;

	@NotBlank
	private String parameterName;

	@NotBlank
	private String parameterValue;

	@NotBlank
	private LocalDateTime assessmenTime;

	@NotBlank
	private String remarks;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public LocalDateTime getAssessmenTime() {
		return assessmenTime;
	}

	public void setAssessmenTime(LocalDateTime assessmenTime) {
		this.assessmenTime = assessmenTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
