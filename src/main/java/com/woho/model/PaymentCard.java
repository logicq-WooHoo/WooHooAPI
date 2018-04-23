package com.woho.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author Pankaj Labade
 *
 */
@Entity
@Table(name = "PAYMENTCARD", uniqueConstraints = @UniqueConstraint(columnNames = { "CARD_NUMBER" }))
public class PaymentCard {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CARD_TYPE", nullable = false)
	private String cardType;

	@Column(name = "CARD_NUMBER", unique = true, nullable = false)
	private Long cardNumber;

	@Column(name = "EXPIRE_ON", nullable = false)
	private String expireOn;

	@Column(name = "CVV", nullable = false)
	private Integer cvv;

	@ManyToOne(cascade = CascadeType.ALL)
	private UserInformation userInformation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpireOn() {
		return expireOn;
	}

	public void setExpireOn(String expireOn) {
		this.expireOn = expireOn;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

}
