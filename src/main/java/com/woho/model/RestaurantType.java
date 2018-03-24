package com.woho.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT_TYPE")
public class RestaurantType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "type")
	private String type;

	@ManyToMany(mappedBy = "restTypes")
	private Set<RestaurantSetup> restaurantSetup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<RestaurantSetup> getRestaurantSetup() {
		return restaurantSetup;
	}

	public void setRestaurantSetup(Set<RestaurantSetup> restaurantSetup) {
		this.restaurantSetup = restaurantSetup;
	}

	@Override
	public String toString() {
		return "RestaurantType [id=" + id + ", type=" + type + ", restaurantSetup=" + restaurantSetup + "]";
	}

}
