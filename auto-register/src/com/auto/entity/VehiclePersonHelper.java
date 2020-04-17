package com.auto.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class VehiclePersonHelper {
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	private String type;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=1, message="is required")
	@Pattern(regexp = "^[a-zA-Z]+$", message="only letters please!")
	private String brand;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="at least 4 characters are required")
	private String model;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	@Pattern(regexp = "^(?:[A-Z]{2}|[B])-\\d{2,3}\\-[A-Z]{3}+$", message="invalid format, PH-99-JAV!")
	private String plate;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=1, message="is required")
	@Pattern(regexp = "^[A-Z0-9]{17}+$", message="invalid format, 17 characters are required")
	private String identificationNumber;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Min(value=200, message="must be greater than or equal to 200")
	@Max(value=6000, message="must be less than or equal to 6000")
	private int cilindricCapacity;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	@Pattern(regexp = "^[a-zA-Z]+$", message="only letters please!")
	private String color;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	@Pattern(regexp = "^[a-zA-Z]+$", message="only letters please!")
	private String fuel;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Min(value=20, message="must be greater than or equal to 20")
	@Max(value=1500, message="must be less than or equal to 1500")
	private int power;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=1, message="is required")
	@Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", message="invalid date!")
	private String productionDate;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	private String polutionNumber;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=13, message="is required, at least 13 characters are required")
	@Size(max=13, message="is required, no more than 13 characters")
	@Pattern(regexp = "^(?:[1]|[2])[0-9]*${12}", message="invalid format!")
	private String uniqueNumberForPerson;
	
	private int vehicleId;

	public VehiclePersonHelper() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public int getCilindricCapacity() {
		return cilindricCapacity;
	}

	public void setCilindricCapacity(int cilindricCapacity) {
		this.cilindricCapacity = cilindricCapacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getPolutionNumber() {
		return polutionNumber;
	}

	public void setPolutionNumber(String polutionNumber) {
		this.polutionNumber = polutionNumber;
	}

	public String getUniqueNumberForPerson() {
		return uniqueNumberForPerson;
	}

	public void setUniqueNumberForPerson(String uniqueNumberForPerson) {
		this.uniqueNumberForPerson = uniqueNumberForPerson;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", brand=" + brand + ", model=" + model + ", plate=" + plate
				+ ", identificationNumber=" + identificationNumber + ", vehicleId=" + vehicleId + "]";
	}	
}
