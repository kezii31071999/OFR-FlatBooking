package com.ofr.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;



@Entity
@Table(name="Flat")
public class Flat {

	@Id
	@Column(name="FLATID",length=15)
	@Min(value=1,message="Id should be positive")
	private Integer flatId;
	
	@Column(name="COST",length=15)
	@Min(value=1000,message="Cost must greater than 1000")
	private Float cost;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="house_No")
  
	private FlatAddress flatAddress;
	

	@Column(name="Availability" , length=15)
	@Size(min=2,max=3,message="Enter valid detail")
	private String availability;

	
	public Flat(Integer flatId, Float cost, FlatAddress flatAddress, String availability) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;
	}

	public Flat() {
		
	}

	public Integer getFlatId() {
		return flatId; 
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public FlatAddress getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", availability="
				+ availability + "]";
	}
	
	
	
}
