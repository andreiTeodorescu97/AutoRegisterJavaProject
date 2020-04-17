package com.auto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auto.entity.Appointment;
import com.auto.entity.AppointmentPersonHelper;
import com.auto.entity.Person;
import com.auto.service.AppointmentService;
import com.auto.service.LogService;
import com.auto.service.VehicleService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LogService logService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// StringTrimerEditor removes whitespace leading and trailing
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/list")
	public String listAppointments(Model theModel) {

		List<Appointment> theAppointments = appointmentService.getAppointments();

		theModel.addAttribute("appointmentsForTheJsp", theAppointments);

		return "list-appointments";
	}

	@GetMapping("/showFormForAdd")
	public String showAddAppointmentForm(Model theModel) {
		theModel.addAttribute("appointmentXperson", new AppointmentPersonHelper());
		return "add-appointment";
	}

	@PostMapping("/addAppoinment")
	public String processForm(
			@Valid @ModelAttribute("appointmentXperson") AppointmentPersonHelper theAppointmentXperson,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "add-appointment";
		} else {
			Person thePerson = new Person();

			if (vehicleService.checkIfPersonExists(theAppointmentXperson.getUniqueNumber()) == true) {
				thePerson = vehicleService.getOwner(theAppointmentXperson.getUniqueNumber());
				if (!thePerson.getFirstName().equals(theAppointmentXperson.getFirstName())
						|| !thePerson.getFirstName().equals(theAppointmentXperson.getFirstName())) {
					return "unique-number-error";
				}
			}
			thePerson.setFirstName(theAppointmentXperson.getFirstName());
			thePerson.setLastName(theAppointmentXperson.getLastName());
			thePerson.setEmail(theAppointmentXperson.getEmail());
			thePerson.setUniqueNumber(theAppointmentXperson.getUniqueNumber());

			// Construct Appointment object
			Appointment theAppointment = new Appointment();
			theAppointment.setDate(theAppointmentXperson.getDate());
			theAppointment.setTime(theAppointmentXperson.getTime());

			try {
				appointmentService.savePersonAndAppointment(thePerson, theAppointment);
			} catch (Exception ex) {
				logService.addLogToDatabase("ERROR", ex.getMessage());
				return "error-page";
			}
			return "appointment-confirmation";

		}
	}

}
