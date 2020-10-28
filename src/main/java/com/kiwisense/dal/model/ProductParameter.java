package com.kiwisense.dal.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "ProductParameter")
@Table(name = "parameter_info", uniqueConstraints={@UniqueConstraint(columnNames = {"parameter_name", "parameter_type", "product_id"})})
public class ProductParameter extends BaseModel{
	
	@NotBlank(message = "*Please provide a parameter name.")
	@Column(name = "parameter_name")
	private String parameterName;

	@NotBlank(message = "*Please provide a parameter type.")
	@Column(name = "parameter_type")
	private String parameterType;

	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	public String getParameterType() {
		return parameterType;
	}

	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
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
