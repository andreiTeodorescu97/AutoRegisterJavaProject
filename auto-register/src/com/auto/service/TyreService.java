package com.auto.service;

import java.util.List;

import com.auto.entity.Tyre;

public interface TyreService {

	void addTyreToDatabase(String tyreDimension);

	List<Tyre> getTyresFromDatabase();

}
