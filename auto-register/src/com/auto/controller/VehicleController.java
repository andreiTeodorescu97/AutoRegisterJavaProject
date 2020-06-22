package com.auto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.auto.entity.Tyre;
import com.auto.entity.Vehicle;
import com.auto.entity.VehiclePersonHelper;
import com.auto.service.LogService;
import com.auto.service.TyreService;
import com.auto.service.VehicleJspService;
import com.auto.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private LogService logService;
	@Autowired
	private TyreService tyreService;
	//@Autowired
	//private VehicleJspService vehicleJspService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// StringTrimerEditor removes whitespace leading and trailing
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/list")
	public String listVehicles(Model theModel) {

		List<Vehicle> theVehicles = vehicleService.getVehicles();

		theModel.addAttribute("listVehicles", theVehicles);
		
		return "list-vehicles";
		
		//return findPaginated(1, theModel);
	}

	
	@GetMapping("/showFormForAddingVehicle")
	public String showAddVehicleForm(Model theModel) {
		theModel.addAttribute("vehicleXperson", new VehiclePersonHelper());
		return "add-vehicle";
	}

	@PostMapping("/addVehicle")
	public String processForm(@Valid @ModelAttribute("vehicleXperson") VehiclePersonHelper theVehicleXperson,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "add-vehicle";
		} else {
			// Check if CNP exists in the database, if not return error, an anonymus user
			// needs to have an appoinment to register the car
			if (vehicleService.checkIfPersonExists(theVehicleXperson.getUniqueNumberForPerson()) == false) {
				return "error";
			}
			VehiclePersonHelper theOldVehicleXperson = null;
			if (theVehicleXperson.getVehicleId() != 0) {
				theOldVehicleXperson = vehicleService.getVehicleAndOwnerFromDatabase(theVehicleXperson.getVehicleId());
			}
			// Add vehicle to database
			vehicleService.addVehicleToDatabase(theVehicleXperson);

			if (theVehicleXperson.getVehicleId() != 0) {
				String logType = "UPDATE";
				String logMessage = "Updated: (OLD VALUE) " + theOldVehicleXperson.toString() + "\n (NEW VALUE) "
						+ theVehicleXperson.toString();
				logService.addLogToDatabase(logType, logMessage);
			}

			return "vehicle-confirmation";
		}
	}

	@GetMapping("/delete")
	public String deleteVehicle(@RequestParam("vehicleIdToDelete") int vehicleId) {

		VehiclePersonHelper theVehicleXperson = vehicleService.getVehicleAndOwnerFromDatabase(vehicleId);
		vehicleService.deleteVehicleFromDatabase(vehicleId);
		String logType = "DELETE";
		String logMessage = "Deleted: " + theVehicleXperson.toString();
		logService.addLogToDatabase(logType, logMessage);
		return "redirect:/vehicle/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showUpdateVehicleForm(@RequestParam("vehicleIdToUpdate") int vehicleId, Model theModel) {

		// get the vehicle from database
		// get the CNP of the owner after you have the person_id from vehicle
		VehiclePersonHelper theVehicleXperson = vehicleService.getVehicleAndOwnerFromDatabase(vehicleId);
		theModel.addAttribute("vehicleXperson", theVehicleXperson);
		return "add-vehicle";
	}
	
	@GetMapping("/showFormForView")
	public String showViewVehicleForm(@RequestParam("vehicleIdToView") int vehicleId, Model theModel) {

		VehiclePersonHelper theVehicleXperson = vehicleService.getVehicleAndOwnerFromDatabase(vehicleId);
		theModel.addAttribute("vehicleXperson", theVehicleXperson);
		
		List<Tyre> theTyres = tyreService.getTyresFromDatabase();

		theModel.addAttribute("nonExistingTyresForTheJsp", theTyres);
		
		return "details-vehicle";
	}
	@GetMapping("/addTyreToVehicle")
	public String processForm(@RequestParam("vehicleIdToAdd") int vehicleId, @RequestParam("tyreIdToAdd") int tyreId) {

		
			
			if(vehicleId != 0 && tyreId != 0) {
				vehicleService.addVehicleAndTyreToDatabase(vehicleId, tyreId);
				//String logType = "Insert";
				//String logMessage = "Inserted: vehicleId=" + vehicleId + ", tyreId=" + tyreId;
				//logService.addLogToDatabase(logType, logMessage);
			}

			return "details-vehicle";
		
	} 
	
	/*@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
		int pageSize = 2;
		
		Page<Vehicle> page = vehicleService.findPaginated(pageNo, pageSize);
		List<Vehicle> listVehicles = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listVehicles", listVehicles);
		
		return "list-vehicles";
	}*/
}
