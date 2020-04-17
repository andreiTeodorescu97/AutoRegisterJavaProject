package com.auto.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AppointmentPersonHelper {
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	private String firstName;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	private String lastName;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=13, message="is required, at least 13 characters are required")
	@Size(max=13, message="is required, no more than 13 characters")
	@Pattern(regexp = "^(?:[1]|[2])[0-9]*${12}", message="invalid format!")
	private String uniqueNumber;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required, at least 4 characters are required")
	@Pattern(regexp = "^(.+)@(.+)$", message="invalid email!")
	private String email;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required")
	@Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", message="invalid date!")
	private String date;
	
	@NotNull(message="is required, dont use white-spaces!!")
	@Size(min=4, message="is required")
	private String time;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUniqueNumber() {
		return uniqueNumber;
	}

	public void setUniqueNumber(String uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
