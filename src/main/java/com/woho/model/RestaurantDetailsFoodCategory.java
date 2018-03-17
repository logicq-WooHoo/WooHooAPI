package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "RESTAURANT_DETAILS_FOOD_CATEGORY")
public class RestaurantDetailsFoodCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "REST_ID")
	private Long restId;

	@Column(name = "CATEGORY_ID")
	private Long foodCategoryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRestId() {
		return restId;
	}

	public void setRestId(Long restId) {
		this.restId = restId;
	}

	public Long getFoodCategoryId() {
		return foodCategoryId;
	}

	public void setFoodCategoryId(Long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}

	@Override
	public String toString() {
		return "RestaurantDetailsFoodCategory [id=" + id + ", restId=" + restId + ", foodCategoryId=" + foodCategoryId
				+ "]";
	}
	
}
