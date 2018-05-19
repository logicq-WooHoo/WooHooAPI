package com.woho.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "HOTEL_REVIEW")
public class HotelReview {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "RECOMMENDATION_COUNT")
	private Integer recommendationCount;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "RATING")
	private Double rating;

	@OneToOne(cascade = CascadeType.ALL)
	private HotelDetails hotelDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRecommendationCount() {
		return recommendationCount;
	}

	public void setRecommendationCount(Integer recommendationCount) {
		this.recommendationCount = recommendationCount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public HotelDetails getHotelDetails() {
		return hotelDetails;
	}

	public void setHotelDetails(HotelDetails hotelDetails) {
		this.hotelDetails = hotelDetails;
	}

	@Override
	public String toString() {
		return "HotelReview [id=" + id + ", recommendationCount=" + recommendationCount + ", comment=" + comment
				+ ", rating=" + rating + ", hotelDetails=" + hotelDetails + "]";
	}

}
