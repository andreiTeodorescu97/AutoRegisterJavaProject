package com.auto.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.auto.entity.Appointment;
import com.auto.entity.Person;

//Always apply Repository to DAO implementatiosn
@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

	//need to inject session factory dependecy
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Appointment> getAppointments() {
		
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		//get the current date
        LocalDate localDate = LocalDate.now();
        var currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
		
		//create&execute query
        Query<Appointment> theQuery = currentSession.createQuery("from Appointment a where a.date>:starDate").setParameter("starDate", currentDate);
        
		//return list of appointments
        List<Appointment> appointmets = theQuery.getResultList();
		
		return appointmets;
	}

	@Override
	public void savePersonAndAppointment(Person thePerson, Appointment theAppointment) {
		Session currentSession = sessionFactory.getCurrentSession();
		thePerson.addAppointment(theAppointment);
		currentSession.saveOrUpdate(thePerson);
		
	}

}
