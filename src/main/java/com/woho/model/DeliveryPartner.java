package com.woho.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class DeliveryPartner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	
	
	@Column(name="name")
	private String name;

	
	@ManyToMany(mappedBy = "deliveryPartners")
	private Set<RestaurantSetup> restaurantSetup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RestaurantSetup> getRestaurantSetup() {
		return restaurantSetup;
	}

	public void setRestaurantSetup(Set<RestaurantSetup> restaurantSetup) {
		this.restaurantSetup = restaurantSetup;
	}
	
	
}
