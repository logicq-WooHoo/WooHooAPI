package com.woho.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TRAVELERPICK")
public class TravelerPick {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(max = 100)
	@Column(name = "MENUID")
	private Long menuId;

	@Size(max = 100)
	@Column(name = "RESTAURANTID")
	private Long restaurantId;

	@Size(max = 100)
	@Column(name = "CITY")
	private String city;

	@Size(max = 20)
	@Column(name = "STATE_CODE")
	private String stateCode;

	@Size(max = 20)
	@Column(name = "COUNTRY_CODE")
	private String countryCode;

	@Size(max = 20)
	@Column(name = "ENTITY")
	private String entity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return "TravelerPick [id=" + id + ", menuId=" + menuId + ", restaurantId=" + restaurantId + ", city=" + city
				+ ", stateCode=" + stateCode + ", countryCode=" + countryCode + ", entity=" + entity + "]";
	}

}
