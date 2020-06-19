package com.auto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.service.VehicleService;

public class PlateConstraintValidator implements ConstraintValidator<UniquePlate, String> {
	
	@Autowired
	private VehicleService vehicleService;

	//private String thePlateNumberToBeVerified;
	
	//@Override
	//public void initialize(UniquePlate thePlateNumberFromClient) {
		//thePlateNumberToBeVerified = thePlateNumberFromClient.value();
	//}
	
	@Override
	public boolean isValid(String thePlateNumberEnteredByUser, ConstraintValidatorContext context) {
		boolean result = vehicleService.checkIfPlateExists(thePlateNumberEnteredByUser);
		return result;
	}

}
