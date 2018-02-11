package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="FOOD_SERVICE_TYPE")
public class FoodServiceType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FOOD_SERVCICETYPE_ID")
	private Long serviceTypeId;
	
	@Size(max = 100)
	@NotNull
	@Column(name="SERVCICETYPE")
	private String serviceType;
	
	@Size(max = 100)
	@Column(name="COMMENT")
	private String comment;

	public Long getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
