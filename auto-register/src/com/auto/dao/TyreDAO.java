package com.auto.dao;

import java.util.List;

import com.auto.entity.Tyre;

public interface TyreDAO {

	void addTyreToDatabase(String tyreDimension);

	List<Tyre> getTyresFromDatabase();
	
}
