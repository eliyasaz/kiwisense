package com.kiwisense.dal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.kiwisense.listeners.BaseModelListener;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(BaseModelListener.class)
public abstract class BaseModel implements Serializable{

	@Id
	@Column(name = "object_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}