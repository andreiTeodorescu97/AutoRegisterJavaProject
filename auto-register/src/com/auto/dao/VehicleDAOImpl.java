package com.auto.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auto.entity.Person;
import com.auto.entity.Statistics;
import com.auto.entity.Tyre;
import com.auto.entity.Vehicle;
import com.auto.entity.VehiclePersonHelper;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean checkIfPersonExists(String cnp) {

		Session currentSession = sessionFactory.getCurrentSession();

		// create&execute query
		Query<Person> theQuery = currentSession.createQuery("from Person p where p.uniqueNumber=:uniqueNumberToCheck").setParameter("uniqueNumberToCheck", cnp);

		// return list of appointments
		List<Person> existingPerson = theQuery.getResultList();

		if (existingPerson.isEmpty()) {

			return false;
		}

		return true;
	}
	
	@Override
	public boolean checkIfPlateExists(String plate) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Vehicle> theQuery = currentSession.createQuery("from Vehicle v where v.plate=:plateEnteredByClient").setParameter("plateEnteredByClient", plate);
		List<Vehicle> existingVehicle = theQuery.getResultList();
		if (existingVehicle.isEmpty()) {

			return true;
		}

		return false;
	}

	@Override
	public void addVehicleToDatabase(@Valid VehiclePersonHelper theVehicleXperson) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Vehicle theCar = new Vehicle();
		theCar.setType(theVehicleXperson.getType());
		theCar.setBrand(theVehicleXperson.getBrand());
		theCar.setModel(theVehicleXperson.getModel());
		theCar.setPlate(theVehicleXperson.getPlate());
		theCar.setIdentificationNumber(theVehicleXperson.getIdentificationNumber());
		theCar.setCilindricCapacity(theVehicleXperson.getCilindricCapacity());
		theCar.setColor(theVehicleXperson.getColor());
		theCar.setFuel(theVehicleXperson.getFuel());
		theCar.setPower(theVehicleXperson.getPower());
		theCar.setProductionDate(theVehicleXperson.getProductionDate());
		theCar.setPolutionNumber(theVehicleXperson.getPolutionNumber());

		LocalDate localDate = LocalDate.now();
		var currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);

		theCar.setRegistrationDate(currentDate);
		theCar.setTax(taxCalculator(theVehicleXperson.getPolutionNumber()));
		if(theCar.getFuel().equals("Electric")) {
			theCar.setAnualTax(0);
		}else
		{
			theCar.setAnualTax(anualTaxCalculator(theVehicleXperson.getType(), theVehicleXperson.getCilindricCapacity()));
		}
		
		theCar.setId_person(findOwner(theVehicleXperson.getUniqueNumberForPerson()));
		theCar.setId(theVehicleXperson.getVehicleId());
		
		currentSession.saveOrUpdate(theCar);

	}

	@Override
	public double taxCalculator(String polutionNumber) {
		switch (polutionNumber) {
		case "EURO 1":
			return 1200;
		case "EURO 2":
			return 1000;
		case "EURO 3":
			return 800;
		case "EURO 4":
			return 600;
		case "EURO 5":
			return 400;
		case "EURO 6":
			return 200;
		case "ELECTRIC":
			return 0;
		}
		return 0;
	}

	@Override
	public double anualTaxCalculator(String vehicleType, int cilindricCapacity) {

		switch (vehicleType) {
		case "Autoturism":
			if (cilindricCapacity < 1600)
				return (double) ((cilindricCapacity / 200) * 8);
			if (cilindricCapacity >= 1600 && cilindricCapacity < 2000)
				return (double) ((cilindricCapacity / 200) * 18);
			if (cilindricCapacity >= 2000 && cilindricCapacity < 3000)
				return (double) ((cilindricCapacity / 200) * 144);
			return (double) ((cilindricCapacity / 200) * 300);
		case "Autobuz":
			return (double) ((cilindricCapacity / 200) * 24);
		case "Autocar":
			return (double) ((cilindricCapacity / 200) * 24);
		case "Motocicleta":
			return (double) ((cilindricCapacity / 200) * 8);
		case "Microbuz":
			return (double) ((cilindricCapacity / 200) * 24);
		case "Tractor":
			return (double) ((cilindricCapacity / 200) * 18);
		}
		return 0;
	}
	
	public int findOwner(String string) {
		Session currentSession = sessionFactory.getCurrentSession();

		// create&execute query
		Query<Person> theQuery = currentSession.createQuery("from Person p where p.uniqueNumber=:uniqueNumberToCheck")
				.setParameter("uniqueNumberToCheck", string);

		// return list of vehicles
		List<Person> existingPerson = theQuery.getResultList();
		
		return existingPerson.get(0).getId();
	}

	@Override
	public List<Vehicle> getVehiclesFromDatabase() {
		//get the current session
		Session currentSession = sessionFactory.getCurrentSession(); 
		
		//create&execute query
        Query<Vehicle> theQuery = currentSession.createQuery("from Vehicle v order by v.productionDate desc");
        
		//return list of vehicles
        List<Vehicle> vehicles = theQuery.getResultList();
		
		return vehicles;
	}

	@Override
	public void deleteVehicleFromDatabase(int vehicleId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Vehicle v where v.id=:idToDelete")
				.setParameter("idToDelete", vehicleId);
		theQuery.executeUpdate();
	}

	@Override
	public VehiclePersonHelper getVehicleAndOwnerFromDatabase(int vehicleId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Vehicle v = currentSession.get(Vehicle.class, vehicleId);
		
		VehiclePersonHelper theVehicleXpersonObject = new VehiclePersonHelper();
		theVehicleXpersonObject.setType(v.getType());
		theVehicleXpersonObject.setBrand(v.getBrand());
		theVehicleXpersonObject.setModel(v.getModel());
		theVehicleXpersonObject.setPlate(v.getPlate());
		theVehicleXpersonObject.setIdentificationNumber(v.getIdentificationNumber());
		theVehicleXpersonObject.setCilindricCapacity(v.getCilindricCapacity());
		theVehicleXpersonObject.setColor(v.getColor());
		theVehicleXpersonObject.setFuel(v.getFuel());
		theVehicleXpersonObject.setPower(v.getPower());
		theVehicleXpersonObject.setProductionDate(v.getProductionDate());
		theVehicleXpersonObject.setPolutionNumber(v.getPolutionNumber());
		theVehicleXpersonObject.setVehicleId(v.getId());
		
		Person owner = currentSession.get(Person.class, v.getId_person());
				
		theVehicleXpersonObject.setUniqueNumberForPerson(owner.getUniqueNumber());
		
		return theVehicleXpersonObject;
	}

	@Override
	public Person getOwner(String uniqueNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Person> theQuery = currentSession.createQuery("from Person p where p.uniqueNumber=:uniqueNumberToCheck")
				.setParameter("uniqueNumberToCheck", uniqueNumber);
		
		List<Person> existingOwner = theQuery.getResultList();
		
		return existingOwner.get(0);
	}

	@Override
	public Statistics getNumberFromDatabase() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Statistics theNumbers = new Statistics();
		LocalDate localDate = LocalDate.now();
		var currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(localDate);
		
		Query query = currentSession.createQuery("select count(distinct v.id) from Vehicle v");
		
		long totalNumberOfVehicles = (long)query.uniqueResult();
		int currentYear = localDate.getYear();
		int currentDay = localDate.getDayOfMonth();
		int currentMonth = localDate.getMonthValue();
		int last10 = currentYear - 10;
		int last5 = currentYear - 5;
		
		String month;
		String day;
		if(currentMonth < 10)
		{
			month = "0" + currentMonth;
		}else {
			month = Integer.toString(currentMonth);
		}
		
		if(currentDay < 10)
		{
			day = "0" + currentDay;
		}else {
			day = Integer.toString(currentDay);
		}
		
		String tenYearsBack = last10 + "-" + month + "-" + day;
		String fiveYearsBack = last5 + "-" + month + "-" + day;
		
		LocalDate date1 = LocalDate.parse(tenYearsBack);
		LocalDate date2 = LocalDate.parse(fiveYearsBack);
		
		var tenYearsBackDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date1);
		var fiveYearsBackDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date2);
				
		Query query2 = currentSession.createQuery("select count(distinct v.id) from Vehicle v where v.productionDate>=:compareDate")
				.setParameter("compareDate", fiveYearsBackDate);
		long totalNumberOfNewVehicles = (long)query2.uniqueResult();
		
		Query query3 = currentSession.createQuery("select count(distinct v.id) from Vehicle v where v.productionDate<:compareDate1 and v.productionDate>=:compareDate2")
				.setParameter("compareDate1", fiveYearsBackDate).setParameter("compareDate2", tenYearsBackDate);
		long totalNumberOfNewVehiclesBetween5and10 = (long)query3.uniqueResult();
		
		Query query4 = currentSession.createQuery("select count(distinct v.id) from Vehicle v where v.productionDate<:compareDate")
				.setParameter("compareDate", tenYearsBack);
		long totalNumberOldest = (long)query4.uniqueResult();
		
		theNumbers.setTotalNumberOfVehicles(totalNumberOfVehicles);
		theNumbers.setNumberOfNewVehicles(totalNumberOfNewVehicles);
		theNumbers.setNumberOfVehiclesOlderBetween5and10(totalNumberOfNewVehiclesBetween5and10);
		theNumbers.setNumberOfVehiclesOlderThan10(totalNumberOldest);
		
		return theNumbers;
	}

	@Override
	//@Transactional(readOnly = true, propagation=Propagation.NOT_SUPPORTED)
	public void addVehicleAndTyreToDatabase(int vehicleId, int tyreId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Vehicle theCar = currentSession.get(Vehicle.class, vehicleId);
		
		Tyre theTyre = currentSession.get(Tyre.class, tyreId);
		
		theCar.addTyre(theTyre);
		
		currentSession.saveOrUpdate(theCar);
		
	}
	
}




















