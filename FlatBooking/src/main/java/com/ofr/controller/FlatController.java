package com.ofr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.model.Flat;
import com.ofr.service.FlatService;

@RestController
@RequestMapping("/flats")
public class FlatController {


	@Autowired
	private FlatService service;

	
	public FlatService getService() {
		return service;
	}

	public void setService(FlatService service) {
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<Boolean> addFlat(@RequestBody Flat flat){
		flat =getService().addFlat(flat);
		@SuppressWarnings({"rawtypes","unchecked"})
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true,HttpStatus.OK);
		System.out.println("response entity="+responseEntity);
		return responseEntity;
	}
	
	@SuppressWarnings({"rawtypes","unchecked"})
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateFlat(@RequestBody Flat flat){
		flat = getService().updateFlat(flat);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteFlat(@RequestBody Flat flat) {
		flat= getService().deleteFlat(flat);
		 @SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		 return responseEntity;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Flat>> viewFlat(@PathVariable("id") Integer id){
		Optional<Flat> entity = getService().viewFlat(id);
		return new ResponseEntity<Optional<Flat>>(entity,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	 public ResponseEntity<List<Flat>> viewAllFlat(){
	    	List<Flat> list = getService().viewAllFlat();
	    	return new ResponseEntity<List<Flat>>(list,new HttpHeaders(),HttpStatus.OK);
	    }
	
	@GetMapping("/find/{cost}/{availability}")
	 public ResponseEntity<List<Flat>> viewAllFlatByCost(@PathVariable Float cost ,@PathVariable String availability){
	    	List<Flat> list = getService().viewAllFlatByCost(cost, availability);
	    	return new ResponseEntity<List<Flat>>(list,new HttpHeaders(),HttpStatus.OK);
	    }
}
