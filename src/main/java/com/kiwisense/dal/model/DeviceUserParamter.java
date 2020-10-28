package com.kiwisense.dal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "DeviceUserParamter")
@Table(name = "device_user_param_info")
public class DeviceUserParamter extends BaseModel{
	
	
	@Column(name = "device_id")
	private Long deviceId;
		
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "parameter_id")
	private Long parameterId;
	
	@Column(name = "parameter_value")
	private String parameterValue;
	
	@Column(name = "assessment_date")
	private LocalDateTime assessmentDate;

	
	@Column(name = "risk_factor")
	private String riskFactor;



	public Long getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getParameterId() {
		return parameterId;
	}


	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}


	public String getParameterValue() {
		return parameterValue;
	}


	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}


	public LocalDateTime getAssessmentDate() {
		return assessmentDate;
	}


	public void setAssessmentDate(LocalDateTime assessmentDate) {
		this.assessmentDate = assessmentDate;
	}


	public String getRiskFactor() {
		return riskFactor;
	}


	public void setRiskFactor(String riskFactor) {
		this.riskFactor = riskFactor;
	}
	
}
