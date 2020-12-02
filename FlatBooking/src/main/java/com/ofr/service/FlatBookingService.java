package com.ofr.service;

import java.util.List;
import java.util.Optional;

import com.ofr.exception.DuplicateFlatBookingException;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.model.FlatBooking;


public interface FlatBookingService {
	FlatBooking addFlatBooking(FlatBooking flatBook)throws DuplicateFlatBookingException;

	FlatBooking updateFlatBooking(FlatBooking flatBook) throws FlatBookingNotFoundException;

	FlatBooking deleteFlatBooking(FlatBooking flatBook) throws FlatBookingNotFoundException;

	Optional<FlatBooking> viewFlatBooking(Integer bookingNo) throws FlatBookingNotFoundException;

	List<FlatBooking> viewAllFlatBooking();

}
