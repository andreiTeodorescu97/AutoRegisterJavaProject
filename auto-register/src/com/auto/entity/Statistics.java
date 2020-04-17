package com.auto.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Statistics {
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	@Pattern(regexp = "^(.+)@(.+)$", message="invalid email!")
	@Column(name="type")
	private String email;
	
	private String message;
			
	private long totalNumberOfVehicles;
	
	private long numberOfVehiclesOlderThan10;
	
	private long numberOfVehiclesOlderBetween5and10;
	
	private long numberOfNewVehicles;
	
	public Statistics() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getTotalNumberOfVehicles() {
		return totalNumberOfVehicles;
	}

	public void setTotalNumberOfVehicles(long totalNumberOfVehicles) {
		this.totalNumberOfVehicles = totalNumberOfVehicles;
	}

	public long getNumberOfVehiclesOlderThan10() {
		return numberOfVehiclesOlderThan10;
	}

	public void setNumberOfVehiclesOlderThan10(long numberOfVehiclesOlderThan10) {
		this.numberOfVehiclesOlderThan10 = numberOfVehiclesOlderThan10;
	}

	public long getNumberOfVehiclesOlderBetween5and10() {
		return numberOfVehiclesOlderBetween5and10;
	}

	public void setNumberOfVehiclesOlderBetween5and10(long numberOfVehiclesOlderBetween5and10) {
		this.numberOfVehiclesOlderBetween5and10 = numberOfVehiclesOlderBetween5and10;
	}

	public long getNumberOfNewVehicles() {
		return numberOfNewVehicles;
	}

	public void setNumberOfNewVehicles(long numberOfNewVehicles) {
		this.numberOfNewVehicles = numberOfNewVehicles;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
