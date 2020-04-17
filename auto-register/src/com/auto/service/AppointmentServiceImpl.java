package com.auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auto.dao.AppointmentDAO;
import com.auto.entity.Appointment;
import com.auto.entity.Person;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	//inject Appointment DAO
	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Override
	@Transactional
	public List<Appointment> getAppointments() {
		
		return appointmentDAO.getAppointments();
	}

	@Override
	@Transactional
	public void savePersonAndAppointment(Person thePerson, Appointment theAppointment) {
		appointmentDAO.savePersonAndAppointment(thePerson, theAppointment);
	}

}
