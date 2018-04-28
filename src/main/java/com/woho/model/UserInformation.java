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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "USERINFORMATION", uniqueConstraints = @UniqueConstraint(columnNames = { "EMAIL", "MOBILENO" }))
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long userId;

	@Size(max = 100)
	@Column(name = "FIRSTNAME")
	private String firstName;

	@Size(max = 100)
	@Column(name = "LASTNAME")
	private String lastName;

	@Email
	@Size(max = 100)
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String emailId;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Size(min = 10, max = 10)
	@Column(name = "MOBILENO", unique = true, nullable = false)
	private String mobileNo;

	@Email
	@Size(max = 15)
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotNull
	@Size(max = 100)
	@Column(name = "USERTYPE")
	private String type;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "UserInformation [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", type=" + type + ", addresses=" + addresses
				+ "]";
	}

}
