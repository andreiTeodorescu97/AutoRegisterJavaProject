package com.auto.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.auto.entity.Tyre;

@Repository
public class TyreDAOImpl implements TyreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTyreToDatabase(String tyreDimension){
		Session currentSession = sessionFactory.getCurrentSession();
		
		Tyre theTyre = new Tyre();
	
		theTyre.setDimension(tyreDimension);
		
		currentSession.save(theTyre);
		
	}

	@Override
	public List<Tyre> getTyresFromDatabase() {
		Session currentSession = sessionFactory.getCurrentSession(); 
        Query<Tyre> theQuery = currentSession.createQuery("from Tyre t order by t.id asc");
        List<Tyre> tyres = theQuery.getResultList();
        
		return tyres;
	}
}
