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
	private Double rating;
	private String phone;
	private String website;
	private Set<String> deliveryPartners;
	private Set<String> restaurantTypes;
	private Set<String> foodCategories;
	private Set<String> foodServiceTypes;
	private Long documentId;
	private String documentName;
	private String documentFilePath;

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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentFilePath() {
		return documentFilePath;
	}

	public void setDocumentFilePath(String documentFilePath) {
		this.documentFilePath = documentFilePath;
	}

	public Set<String> getFoodCategories() {
		return foodCategories;
	}

	public void setFoodCategories(Set<String> foodCategories) {
		this.foodCategories = foodCategories;
	}

	public Set<String> getFoodServiceTypes() {
		return foodServiceTypes;
	}

	public void setFoodServiceTypes(Set<String> foodServiceTypes) {
		this.foodServiceTypes = foodServiceTypes;
	}

	@Override
	public String toString() {
		return "RestaurantVO [id=" + id + ", restaurantName=" + restaurantName + ", city=" + city + ", area=" + area
				+ ", recommendationCount=" + recommendationCount + ", rating=" + rating + ", phone=" + phone
				+ ", website=" + website + ", deliveryPartners=" + deliveryPartners + ", restaurantTypes="
				+ restaurantTypes + ", foodCategories=" + foodCategories + ", foodServiceTypes=" + foodServiceTypes
				+ ", documentId=" + documentId + ", documentName=" + documentName + ", documentFilePath="
				+ documentFilePath + "]";
	}

}
