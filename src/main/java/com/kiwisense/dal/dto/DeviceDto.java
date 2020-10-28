package com.kiwisense.dal.dto;


import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class DeviceDto{

	@Length(min = 5, message = "*Your device name must have at least 5 characters.")
	@Length(max = 255, message = "*Your device name can have upto 1000 characters.")
	@NotEmpty(message = "*Please provide a device name")
	private String deviceName;

	@Length(max = 1000, message = "*Your device descriptioncan have max 1000 characters.")
	private String description;
	
	@Length(max = 1000, message = "*Your device descriptioncan have max 1000 characters.")
	private String remark;
	
	private LocalDateTime soldDate;

	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(LocalDateTime soldDate) {
		this.soldDate = soldDate;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
