package com.woho.vo;

public class MenuItemVO {
	
	private Long id;
	
	private Long foodServiceTypeId;
	
	private Long foodCategoryId;
	
	private String itemName;
	
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFoodServiceTypeId() {
		return foodServiceTypeId;
	}

	public void setFoodServiceTypeId(Long foodServiceTypeId) {
		this.foodServiceTypeId = foodServiceTypeId;
	}

	public Long getFoodCategoryId() {
		return foodCategoryId;
	}

	public void setFoodCategoryId(Long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
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
