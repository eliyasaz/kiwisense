package com.kiwisense.dal.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity(name = "Device")
@Table(name = "device_info", uniqueConstraints={@UniqueConstraint(columnNames = {"device_name"})})
public class Device extends BaseModel{

	@Column(name = "device_name")
	@Length(min = 5, message = "*Your device name must have at least 5 characters.")
	@Length(max = 255, message = "*Your device name can have upto 200 characters.")
	@NotEmpty(message = "*Please provide a device name")
	private String deviceName;

	@Column(name = "description")
	@Length(max = 1000, message = "*Your device descriptioncan have max 1000 characters.")
	private String description;
	
	@Column(name = "device_remark")
	@Length(max = 1000, message = "*Your device descriptioncan have max 1000 characters.")
	private String remark;
	
	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDateTime createDateTime;

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	@Column(name = "sold_date")
	private LocalDateTime soldDate;

	
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	@OneToOne
	@JoinColumn(name = "assigned_to")
	private User assignedTo;
	
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
