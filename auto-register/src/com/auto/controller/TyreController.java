package com.auto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auto.entity.Tyre;
import com.auto.service.TyreService;

@Controller
@RequestMapping("/tyre")
public class TyreController {
	
	@Autowired
	private TyreService tyreService;

	@GetMapping("/showFormForAddingTyre")
	public String showAddTyreForm(Model theModel) {
		theModel.addAttribute("tyre", new Tyre());
		return "add-tyre";
	}

	@PostMapping("/addTyre")
	public String processForm(@Valid @ModelAttribute("tyre") Tyre theTyre,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "add-tyre";
		} else {
			// Check if CNP exists in the database, if not return error, an anonymus user
			// needs to have an appoinment to register the car
			/*if (vehicleService.checkIfPersonExists(theVehicleXperson.getUniqueNumberForPerson()) == false) {
				return "error";
			}*/
			
			/*
			Tyre theOldTyre = null;
			if (theTyre.getId() != 0) {
				theOldTyre = vehicleService.getVehicleAndOwnerFromDatabase(theVehicleXperson.getVehicleId());
			}*/
			// Add vehicle to database
			
			tyreService.addTyreToDatabase(theTyre.getDimension());

			return "tyre-confirmation";
		}
	}
	
	@GetMapping("/list")
	public String listTyres(Model theModel) {
		List<Tyre> theTyres = tyreService.getTyresFromDatabase();
		theModel.addAttribute("tyresForTheJsp", theTyres);
		return "list-tyres";
	}

}
