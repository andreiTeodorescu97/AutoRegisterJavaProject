package com.auto.service;

import java.util.List;

import com.auto.entity.Appointment;
import com.auto.entity.Person;

public interface AppointmentService {
	
	public List<Appointment> getAppointments();

	public void savePersonAndAppointment(Person thePerson, Appointment theAppointment);
	
}
