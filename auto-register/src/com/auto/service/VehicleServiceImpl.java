package com.auto.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auto.dao.VehicleDAO;
import com.auto.entity.Person;
import com.auto.entity.Statistics;
import com.auto.entity.Vehicle;
import com.auto.entity.VehiclePersonHelper;

@Service
public class VehicleServiceImpl implements VehicleService {

	// inject Vehicle DAO
	@Autowired
	private VehicleDAO vehicleDAO;

	@Override
	@Transactional
	public boolean checkIfPersonExists(String cnp) {
		return vehicleDAO.checkIfPersonExists(cnp);
	}

	@Override
	@Transactional
	public void addVehicleToDatabase(@Valid VehiclePersonHelper theVehicleXperson) {
		vehicleDAO.addVehicleToDatabase(theVehicleXperson);
	}

	@Override
	@Transactional
	public List<Vehicle> getVehicles() {
		return vehicleDAO.getVehiclesFromDatabase();
	}

	@Override
	@Transactional
	public void deleteVehicleFromDatabase(int vehicleId) {
		vehicleDAO.deleteVehicleFromDatabase(vehicleId);
		
	}

	@Override
	@Transactional
	public VehiclePersonHelper getVehicleAndOwnerFromDatabase(int vehicleId) {
		return vehicleDAO.getVehicleAndOwnerFromDatabase(vehicleId);
	}

	@Override
	@Transactional
	public Person getOwner(String uniqueNumber) {
		return vehicleDAO.getOwner(uniqueNumber);
	}

	@Override
	@Transactional
	public Statistics getNumberFromDatabase() {
		return vehicleDAO.getNumberFromDatabase();
	}

	@Override
	@Transactional
	public void addVehicleAndTyreToDatabase(int vehicleId, int tyreId) {
		vehicleDAO.addVehicleAndTyreToDatabase(vehicleId,tyreId);
		
	}
	
	@Override
	@Transactional
	public boolean checkIfPlateExists(String plate) {
		return vehicleDAO.checkIfPlateExists(plate);
	}
	
	

}
