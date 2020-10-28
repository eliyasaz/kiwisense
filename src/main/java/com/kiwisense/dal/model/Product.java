package com.kiwisense.dal.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Product")
@Table(name = "product_info")
public class Product extends BaseModel{
	@NotBlank(message = "*Please provide a product name.")
	@Column(name = "product_name")
	private String productName;
	
	@NotBlank(message = "*Please provide a product category.")
	@Column(name = "product_category")
	private String productCategory;
	
	@NotBlank(message = "*Please provide a product vendor.")
	@Column(name = "product_vendor")
	private String vendor;
	
	@Column(name = "product_status")
	private String status;
	
	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Device> devices;

	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductParameter> parameters;
	
	public Set<ProductParameter> getParameters() {
		return parameters;
	}

	public void setParameters(Set<ProductParameter> parameters) {
		this.parameters = parameters;
	}

	public void addParamter(ProductParameter param) {
		if(this.getParameters() != null) {
			this.getParameters().add(param);
		}else {
			Set<ProductParameter> params = new HashSet<ProductParameter>();
			params.add(param);
			this.setParameters(params);
		}
	}
	
	public void addDevice(Device device) {
		if(this.getDevices() != null) {
			this.getDevices().add(device);
		}else {
			Set<Device> devices = new HashSet<Device>();
			devices.add(device);
			this.setDevices(devices);
		}
	}


	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

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

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	


}
