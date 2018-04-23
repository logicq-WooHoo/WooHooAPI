package com.woho.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PaymentCardVO {

	private String cardType;

	private Long cardNumber;

	private String expireOn;

	private Integer cvv;

	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PaymentCardVO [cardType=" + cardType + ", cardNumber=" + cardNumber + ", expireOn=" + expireOn
				+ ", cvv=" + cvv + ", userId=" + userId + "]";
	}
}
