package com.auto.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.auto.entity.Statistics;

import com.auto.service.LogService;
import com.auto.service.VehicleService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private LogService logService;
	
	@Autowired
	private VehicleService vehicleService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// StringTrimerEditor removes whitespace leading and trailing
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showEmailForm")
	public String showAddAppointmentForm(Model theModel) {
		Statistics nr = vehicleService.getNumberFromDatabase();
		theModel.addAttribute("statistics", nr);
		return "statistics";
	}

	@RequestMapping("/sendMail")
	public String sendMail(@Valid @ModelAttribute("statistics") Statistics statistics, BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "error-page";
		} else {

			Properties properties = new Properties();

			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");

			String myAccountEmail = "javaproject997@gmail.com";
			String myAccountPassword = "java1997@";
			String mailTo = statistics.getEmail();

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail, myAccountPassword);
				}
			});

			Message message = prepareMessage(session, myAccountEmail, mailTo, statistics);
			
			try {
				
				Transport.send(message);
				
			} catch (MessagingException e) {
				
				logService.addLogToDatabase("MAIL ERROR 1", e.getMessage());
				e.printStackTrace();
				return "error-page";
				
			}
			
			return "mail-confirmation";
		}

	}

	private Message prepareMessage(Session session, String myAccountEmail, String mailTo, Statistics statistics) {
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			LocalDate currentlocalDate = LocalDate.now();
			var currentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(currentlocalDate);
			message.setSubject("Statistici Registrul Auto Roman");
			String htmlCode = "<h1> Statistici din data de: " + currentDate + "</h1>" +
								"Numarul total de vehicule inregistrate: " + statistics.getTotalNumberOfVehicles()  + "<br>" +
								"Numarul de vehicule cu o vechime pana in 5 ani: " + statistics.getNumberOfNewVehicles()  + "<br>" +
								"Numarul de vehicule cu o vechime cuprinsa intre 5 si 10 ani: " + statistics.getNumberOfVehiclesOlderBetween5and10()  + "<br>" +
								"Numarul de vehicule cu o vechime mai mare de 10 ani: " + statistics.getNumberOfVehiclesOlderThan10()  + "<br>";
			message.setContent(htmlCode,"text/html");
			return message;
			
		} catch (AddressException e) {
			
			logService.addLogToDatabase("MAIL ERROR 2", e.getMessage());
			e.printStackTrace();

		} catch (MessagingException e) {
			
			logService.addLogToDatabase("MAIL ERROR 3", e.getMessage());
			e.printStackTrace();
			
		}

		return null;
	}

}
