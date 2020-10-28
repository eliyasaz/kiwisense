package com.kiwisense.dal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Role")
@Table(name = "role_info")
public class Role extends BaseModel{
  
	@Enumerated(EnumType.STRING)
	@Column(length = 40)
	private ERole name;

	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

		public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	@Column(name = "created_date")
	@CreationTimestamp
	private LocalDateTime createDateTime;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

}