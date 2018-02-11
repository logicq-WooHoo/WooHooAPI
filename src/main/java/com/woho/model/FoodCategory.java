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
@Table(name="FOOD_CATEGORY")
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CATEGORYID")
	private Long categoryId;
	
	@Size(max = 100)
	@NotNull
	@Column(name="CATEGORY")
	private String category;
	
	@Size(max = 100)
	@Column(name="SUBCATEGORY")
	private String subCategory;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	

}
