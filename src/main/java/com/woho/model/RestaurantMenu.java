package com.woho.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RESTAURANT_MENU")
public class RestaurantMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<MenuItem> menuItems = new HashSet<>();

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

	@Override
	public String toString() {
		return "RestaurantMenu [id=" + id + ", menuItems=" + menuItems + "]";
	}
	
}
