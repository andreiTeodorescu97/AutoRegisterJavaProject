package com.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auto.dao.TyreDAO;
import com.auto.entity.Tyre;

@Service
public class TyreServiceImpl implements TyreService {

	@Autowired
	private TyreDAO TyreDAO;
	
	@Override
	@Transactional
	public void addTyreToDatabase(String tyreDimension) {
		TyreDAO.addTyreToDatabase(tyreDimension);

	}

	@Transactional
	public List<Tyre> getTyresFromDatabase() {
		return TyreDAO.getTyresFromDatabase();
	}
	
}
