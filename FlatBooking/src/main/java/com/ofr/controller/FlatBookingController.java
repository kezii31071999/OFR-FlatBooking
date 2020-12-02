package com.ofr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.exception.DuplicateFlatBookingException;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.model.FlatBooking;
import com.ofr.service.FlatBookingService;

@RestController
@RequestMapping("/flatBooking")
@Validated
public class FlatBookingController {

	@Autowired
	private FlatBookingService service;
	

	public FlatBookingService getService() {
		return service;
	}

	public void setService(FlatBookingService service) {
		this.service = service;
	}

	@GetMapping("/all") // http://localhost:7880/flatBooking/all
	public ResponseEntity<List<FlatBooking>> viewAllFlatBooking() {
		List<FlatBooking> list = getService().viewAllFlatBooking();
		return new ResponseEntity<List<FlatBooking>>(list, new HttpHeaders(), HttpStatus.OK);// 200,json
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<FlatBooking>> viewFlatBooking(@PathVariable("bookingNo")Integer bookingNo )  throws FlatBookingNotFoundException{
		Optional<FlatBooking> entity = getService().viewFlatBooking(bookingNo);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Optional<FlatBooking>> responseEntity = new ResponseEntity(entity, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/add")
	public ResponseEntity<Boolean> addFlatBooking(@Valid @RequestBody FlatBooking flatBook) throws DuplicateFlatBookingException {
		flatBook = getService().addFlatBooking(flatBook);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity = " + responseEntity);
		return responseEntity;

	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> updateFlatBooking(@Valid @RequestBody FlatBooking flatBook)  throws FlatBookingNotFoundException{
		flatBook = getService().updateFlatBooking(flatBook);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/remove")
	public ResponseEntity<Boolean> deleteFlatBooking(@RequestBody FlatBooking flatBook)  throws FlatBookingNotFoundException{
		getService().deleteFlatBooking(flatBook);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

}
