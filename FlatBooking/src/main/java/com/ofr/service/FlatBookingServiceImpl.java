package com.ofr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofr.dao.FlatBookingDao;
import com.ofr.exception.DuplicateFlatBookingException;
import com.ofr.exception.FlatBookingNotFoundException;
import com.ofr.model.FlatBooking;

@Service("flatBookingService")
@Transactional
public class FlatBookingServiceImpl implements FlatBookingService {

	@Autowired
	private FlatBookingDao flatBookingDao;
	
		
	public FlatBookingDao getFlatBookingDao() {
		return flatBookingDao;
	}

	public void setFlatBookingDao(FlatBookingDao flatBookingDao) {
		this.flatBookingDao = flatBookingDao;
	}

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatbook) throws DuplicateFlatBookingException{
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(flatbook.getBookingNo());
		if(flatbook1.isPresent())
		{
			throw new DuplicateFlatBookingException("The FlatBooking Details Already Exists");
		}
		return getFlatBookingDao().save(flatbook);
	}

	@Override
	public FlatBooking updateFlatBooking(FlatBooking flatbook) throws FlatBookingNotFoundException{
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(flatbook.getBookingNo());
		if(flatbook1.isPresent())
		{
			return getFlatBookingDao().save(flatbook);
		}
		else
		{
		throw new FlatBookingNotFoundException("Booking of Flat is not Updated");
		}
	}

	@Override
	public FlatBooking deleteFlatBooking(FlatBooking flatbook) throws FlatBookingNotFoundException{
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(flatbook.getBookingNo());
		if(flatbook1.isPresent())
		{
			getFlatBookingDao().delete(flatbook);
			 return flatbook;
		}
		else
		{
		throw new FlatBookingNotFoundException("Booking of Flat is not Deleted");
		}
		
	}

	@Override
	public Optional<FlatBooking> viewFlatBooking(Integer bookingNo) throws FlatBookingNotFoundException{
		Optional<FlatBooking> flatbook1 = flatBookingDao.findById(bookingNo);
		if(flatbook1.isPresent())
		{
			return getFlatBookingDao().findById(bookingNo);
		}
		else
		{
		throw new FlatBookingNotFoundException("Booking of Flat is not Deleted");
		}
		
	}

	@Override
	public List<FlatBooking> viewAllFlatBooking() {
		List<FlatBooking> flatBookList = getFlatBookingDao().findAll();
		return flatBookList;
	}
 

}
