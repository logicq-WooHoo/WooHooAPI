package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FoodServiceType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private String id;
	
	private String type;
	
	private String name;
	
	@Lob
    @Column(name="image", nullable=false, columnDefinition="mediumblob")
    private byte[] image;
	
	private long price;
	
	private String category;

}
