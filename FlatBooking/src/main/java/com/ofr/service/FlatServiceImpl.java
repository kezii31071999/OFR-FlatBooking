package com.ofr.service;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofr.dao.FlatDao;
import com.ofr.model.Flat;


@Service
@Transactional
public class FlatServiceImpl implements FlatService{

	@Autowired
	private FlatDao dao;
	
	
	public FlatDao getDao() {
		return dao;
	}

	public void setDao(FlatDao dao) {
		this.dao = dao;
	}

	@Override
	public Flat addFlat(Flat flat) {
		return getDao() .save(flat);
	}

	@Override
	public Flat updateFlat(Flat flat) {
		return getDao().save(flat);
	}

	@Override
	public Flat deleteFlat(Flat flat) {
		getDao() .delete(flat);
		 return flat;
	}

	@Override
	public Optional<Flat> viewFlat(Integer id) {
		return getDao().findById(id);
	}

	@Override
	public List<Flat> viewAllFlat() {
		return getDao().findAll();
	}

	@Override
	public List<Flat> viewAllFlatByCost(Float cost, String availability) {
		return getDao().viewAllFlatByCost(cost, availability);
	}

	
}
