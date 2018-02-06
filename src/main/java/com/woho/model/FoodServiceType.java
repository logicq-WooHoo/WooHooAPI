package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodServiceType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SERVCICETYPEID")
	private Long serviceTypeId;
	
	@Column(name="SERVCICETYPE")
	private String serviceType;
	
	@Column(name="COMMENT")
	private String comment;
	
}
