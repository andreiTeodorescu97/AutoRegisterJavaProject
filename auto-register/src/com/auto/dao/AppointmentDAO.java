package com.auto.dao;

import java.util.List;

import com.auto.entity.Appointment;
import com.auto.entity.Person;

public interface AppointmentDAO {
	
	public List<Appointment> getAppointments();

	public void savePersonAndAppointment(Person thePerson, Appointment theAppointment);
}
