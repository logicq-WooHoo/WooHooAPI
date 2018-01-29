package com.woho.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="UserInformation")
public class UserInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private String userId;
	
	@NotNull
	@Column(name="title")
	private String title;
	
	@NotNull
    @Size(max = 100)
	@Column(name="firstname")
	private String firstName;
	
	@NotNull
    @Size(max = 100)
	@Column(name="lastname")
	private String lastName;
	
	@NotNull
    @Size(max = 100)
	@Column(name="profileid")
	private String profileId;
	
	@Email
	@NotNull
    @Size(max = 100)
	@Column(name="emailid")
	private String emailId;
	
	@OneToMany(
				mappedBy = "address", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private List<Address> addresses = new ArrayList<>();	

	public void removeAddresses(Address address) {
		addresses.remove(address);
		address.setUser(null);
	}

	public void addAddresses(Address address) {
		addresses.add(address);
		address.setUser(this);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getProfile() {
		return profileId;
	}

	public void setProfile(String profileId) {
		this.profileId = profileId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
