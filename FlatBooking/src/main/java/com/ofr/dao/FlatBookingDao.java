package com.ofr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofr.model.FlatBooking;

public interface FlatBookingDao extends JpaRepository <FlatBooking,Integer>{

	
}
