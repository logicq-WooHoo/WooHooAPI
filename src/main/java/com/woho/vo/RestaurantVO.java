package com.woho.vo;

import java.util.Set;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class RestaurantVO {
	
	private Long id;
	private String restaurantName;
	private String city;
	private String area;
	private Integer recommendationCount;
	private Set<String> deliveryPartners;
	private Set<String> restaurantTypes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getRecommendationCount() {
		return recommendationCount;
	}
	public void setRecommendationCount(Integer recommendationCount) {
		this.recommendationCount = recommendationCount;
	}
	public Set<String> getDeliveryPartners() {
		return deliveryPartners;
	}
	public void setDeliveryPartners(Set<String> deliveryPartners) {
		this.deliveryPartners = deliveryPartners;
	}
	public Set<String> getRestaurantTypes() {
		return restaurantTypes;
	}
	public void setRestaurantTypes(Set<String> restaurantTypes) {
		this.restaurantTypes = restaurantTypes;
	}
	
	@Override
	public String toString() {
		return "RestaurantVO [id=" + id + ", restaurantName=" + restaurantName + ", city=" + city + ", area=" + area
				+ ", recommendationCount=" + recommendationCount + ", deliveryPartners=" + deliveryPartners
				+ ", restaurantTypes=" + restaurantTypes + "]";
	}

}
