package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORYID")
	private Long categoryId;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="SUBCATEGORY")
	private String subCategory;
	

}
