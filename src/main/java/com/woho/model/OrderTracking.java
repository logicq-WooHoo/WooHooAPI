package com.woho.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ORDER_TRACKING")
public class OrderTracking {

	/**
	 * Tracking id : Randomly generated alphanumeric string
	 */
	@Id
	@Column(name = "ID", nullable = false)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP", nullable = false)
	private Date timestamp;

	@Lob
	@Column(name = "ORDER_JSON", nullable = false)
	private byte[] orderJson;

	@OneToOne(fetch = FetchType.LAZY)
	@NotNull
	private UserInformation userInformation;

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

	public byte[] getOrderJson() {
		return orderJson;
	}

	public void setOrderJson(byte[] orderJson) {
		this.orderJson = orderJson;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Override
	public String toString() {
		return "OrderTracking [id=" + id + ", timestamp=" + timestamp + ", orderJson=" + Arrays.toString(orderJson)
				+ ", userInformation=" + userInformation + "]";
	}
}
