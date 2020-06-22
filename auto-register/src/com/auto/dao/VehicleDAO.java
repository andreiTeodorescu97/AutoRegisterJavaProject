package com.auto.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.entity.Person;
import com.auto.entity.Statistics;
import com.auto.entity.Vehicle;
import com.auto.entity.VehiclePersonHelper;

//extends JpaRepository<Vehicle, Long>
public interface VehicleDAO  {
	
	public boolean checkIfPersonExists(String cnp);
	
	public boolean checkIfPlateExists(String plate);

	public void addVehicleToDatabase(@Valid VehiclePersonHelper theVehicleXperson);
	
	public double taxCalculator(String polutionNumber);
	
	public double anualTaxCalculator(String vehicleType, int cilindriCapacity);

	public List<Vehicle> getVehiclesFromDatabase();

	public void deleteVehicleFromDatabase(int vehicleId);

	public VehiclePersonHelper getVehicleAndOwnerFromDatabase(int vehicleId);

	public Person getOwner(String uniqueNumber);

	public Statistics getNumberFromDatabase();
	
	public void addVehicleAndTyreToDatabase(int vehicleId, int tyreId);

	//boolean checkIfPlateExists(String plate);

}
