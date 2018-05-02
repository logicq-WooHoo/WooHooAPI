package com.woho.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT_MENU")
public class RestaurantMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<MenuItem> menuItems = new HashSet<>();

	@OneToOne
	private RestaurantDetails restaurantDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<FoodCategory> foodCategories = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<FoodServiceType> foodServiceTypes = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public RestaurantDetails getRestaurantDetails() {
		return restaurantDetails;
	}

	public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
		this.restaurantDetails = restaurantDetails;
	}

	public Set<FoodCategory> getFoodCategories() {
		return foodCategories;
	}

	public void setFoodCategories(Set<FoodCategory> foodCategories) {
		this.foodCategories = foodCategories;
	}

	public Set<FoodServiceType> getFoodServiceTypes() {
		return foodServiceTypes;
	}

	public void setFoodServiceTypes(Set<FoodServiceType> foodServiceTypes) {
		this.foodServiceTypes = foodServiceTypes;
	}

	@Override
	public String toString() {
		return "RestaurantMenu [id=" + id + ", menuItems=" + menuItems + ", restaurantDetails=" + restaurantDetails
				+ ", foodCategories=" + foodCategories + ", foodServiceTypes=" + foodServiceTypes + "]";
	}

}
