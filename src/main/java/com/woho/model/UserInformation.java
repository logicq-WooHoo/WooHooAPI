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
	@Column(name="ID")
	private Long userId;
	
    @Size(max = 100)
	@Column(name="FIRSTNAME")
	private String firstName;
	
    @Size(max = 100)
	@Column(name="LASTNAME")
	private String lastName;
	
	
	@Email
    @Size(max = 100)
	@Column(name="EMAIL")
	private String emailId;
	
	@NotNull
	@Size(max = 100)
	@Column(name="MOBILENO")
	private Long mobileNo;
	
	@NotNull
	@Size(max = 100)
	@Column(name="USER_TYPE")
	private String type;
	
	@OneToMany(
				mappedBy = "address", 
		        cascade = CascadeType.ALL, 
		        orphanRemoval = true
		    )
	private List<Address> addresses = new ArrayList<>();	


}
