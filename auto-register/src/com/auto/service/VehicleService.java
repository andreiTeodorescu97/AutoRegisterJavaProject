package com.auto.service;

import java.util.List;

import javax.validation.Valid;

import com.auto.entity.Person;
import com.auto.entity.Statistics;
import com.auto.entity.Vehicle;
import com.auto.entity.VehiclePersonHelper;

import org.springframework.data.domain.Page;

public interface VehicleService {
	
	public boolean checkIfPersonExists(String cnp);

	public void addVehicleToDatabase(@Valid VehiclePersonHelper theVehicleXperson);

	public List<Vehicle> getVehicles();

	public void deleteVehicleFromDatabase(int vehicleId);

	public VehiclePersonHelper getVehicleAndOwnerFromDatabase(int vehicleId);

	public Person getOwner(String uniqueNumber);
	
	public Statistics getNumberFromDatabase();
	
	public void addVehicleAndTyreToDatabase(int vehicleId, int tyreId);

	boolean checkIfPlateExists(String plate);
	
	Page<Vehicle> findPaginated(int pageNo, int pageSize);
	
}
