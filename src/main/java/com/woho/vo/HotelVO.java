package com.woho.vo;

import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Pankaj Labade
 *
 */
public class HotelVO extends AddressVO {

	private Long id;

	private String hotelName;

	private String city;

	private String area;

	private String type;

	private Integer recommendationCount;

	private Double rating;

	private Set<String> amenities;

	private Map<String, Double> outServices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Set<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(Set<String> amenities) {
		this.amenities = amenities;
	}

	public Map<String, Double> getOutServices() {
		return outServices;
	}

	public void setOutServices(Map<String, Double> outServices) {
		this.outServices = outServices;
	}

	@Override
	public String toString() {
		return "HotelVO [id=" + id + ", hotelName=" + hotelName + ", city=" + city + ", area=" + area + ", type=" + type
				+ ", recommendationCount=" + recommendationCount + ", rating=" + rating + ", amenities=" + amenities
				+ ", outServices=" + outServices + "]";
	}

}
