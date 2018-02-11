package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MENU_ITEM")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MENU_ITEM_ID")
	private Long id;
	
	@OneToOne
	private FoodServiceType foodServiceType;
	
	@OneToOne
	private FoodCategory foodCategory;
	
	@Column(name="NAME")
	private String itemName;
	
	@Column(name="PRICE")
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FoodServiceType getFoodServiceType() {
		return foodServiceType;
	}

	public void setFoodServiceType(FoodServiceType foodServiceType) {
		this.foodServiceType = foodServiceType;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
