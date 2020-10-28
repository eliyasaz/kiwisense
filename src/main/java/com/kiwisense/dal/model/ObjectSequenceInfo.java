package com.kiwisense.dal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the range of id's that are available for new instances
 * of an object.
 */
@Entity
@Table(name = "object_sequence_info")
public class ObjectSequenceInfo {
	@Id
	@Column(name = "object_name")
	private String objectName;

	@Column(name = "sequence_increment")
	private long currentValue;

	@Column(name = "max_used_sequence")
	private long maxValue;

	public ObjectSequenceInfo(String objectName) {
		this.objectName = objectName;
	}

	public ObjectSequenceInfo() {

	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public long getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(long currentValue) {
		this.currentValue = currentValue;
	}

	public long incrementCurrentValue() {
		return this.currentValue++;
	}

	public long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(long maxValue) {
		this.maxValue = maxValue;
	}
}
