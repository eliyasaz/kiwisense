package com.kiwisense.dal.dto;

import javax.validation.constraints.NotBlank;

public class ProductDto {
	@NotBlank(message = "*Please provide a product name.")
	private String productName;

	@NotBlank(message = "*Please provide a product category.")
	private String productCategory;

	@NotBlank(message = "*Please provide a product vendor.")
	private String vendor;

	private String status;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
