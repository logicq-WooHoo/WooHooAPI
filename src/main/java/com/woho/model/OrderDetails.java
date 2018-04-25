package com.woho.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

	/**
	 * Order id : Randomly generated alphanumeric string
	 */
	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP", nullable = false)
	private Date timestamp;

	@OneToOne(cascade = CascadeType.ALL)
	private Address deliveryAddresses;

	@OneToOne(fetch = FetchType.LAZY)
	@NotNull
	private UserInformation userInformation;

	@OneToMany(fetch = FetchType.LAZY)
	@NotNull
	private List<OrderTracking> orderTrackings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Address getDeliveryAddresses() {
		return deliveryAddresses;
	}

	public void setDeliveryAddresses(Address deliveryAddresses) {
		this.deliveryAddresses = deliveryAddresses;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	public List<OrderTracking> getOrderTrackings() {
		return orderTrackings;
	}

	public void setOrderTrackings(List<OrderTracking> orderTrackings) {
		this.orderTrackings = orderTrackings;
	}

}
