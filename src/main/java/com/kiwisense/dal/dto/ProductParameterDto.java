package com.kiwisense.dal.dto;

import javax.validation.constraints.NotBlank;

public class ProductParameterDto {

	@NotBlank(message = "*Please provide a parameter name.")
	private String parameterName;
	
	@NotBlank(message = "*Please provide a parameter type.")
	private String parameterType;
	
	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

}
