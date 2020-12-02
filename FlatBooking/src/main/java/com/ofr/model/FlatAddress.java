package com.ofr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="FlatAddress")
public class FlatAddress {

	@Id
	@Column(name="house_No" , length=15)
	private Integer houseNo;
	@Column(name="Street" , length=15)
	private String street;
	@Column(name="City" , length=15)
	private String city;
	@Column(name="State" , length=15)
	private String state;
	@Column(name="Pin" , length=15)
	private Integer pin;
	@Column(name="Country" , length=15)
	private String country;
	
	@OneToOne(targetEntity = Flat.class)
	private Flat flat;
	
	@OneToOne(targetEntity = FlatBooking.class)
	private FlatBooking flatBook;
	
 
	public FlatAddress(Integer houseNo, String street, String city, String state, Integer pin, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}

	public FlatAddress() {
		
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public Integer getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 

	@Override
	public String toString() {
		return "FlatAddress [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", country=" + country + "]";
	}

}
