package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private String id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	//many to many between  hotel and restaurent type (id of restaurent information)
	
}
