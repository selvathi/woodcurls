package com.niit.furniturebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 int address_id;
	@Column(nullable = false)
	String b_name;
	
	@Column(nullable = false)
	@NotEmpty(message="its required")
	String address_Line1;
	
	@Column(nullable = false)
	String address_Line2;
	
	@Column(nullable = false)
	@NotEmpty(message="its required")
	String city;
	
	@Column(nullable = false)
	@NotEmpty(message="its required")
	String state;
	
	@Column(nullable = false)
	
    int pincode;
	
	@ManyToOne
	UserDetails userdetails;

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_Line1() {
		return address_Line1;
	}

	public void setAddress_Line1(String address_Line1) {
		this.address_Line1 = address_Line1;
	}

	public String getAddress_Line2() {
		return address_Line2;
	}

	public void setAddress_Line2(String address_Line2) {
		this.address_Line2 = address_Line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	
}
