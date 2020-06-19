package com.auto.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="plate")
	private String plate;
	
	@Column(name="identificationNumber")
	private String identificationNumber;
	
	@Column(name="cilindricCapacity")
	private int cilindricCapacity;
	
	@Column(name="color")
	private String color;
	
	@Column(name="fuel")
	private String fuel;
	
	@Column(name="power")
	private int power;
	
	@Column(name="productionDate")
	private String productionDate;
	
	@Column(name="polutionNumber")
	private String polutionNumber;
	
	@Column(name="tax")
	private double tax;
	
	@Column(name="anualTax")
	private double anualTax;
	
	@Column(name="id_person")
	private int id_person;
	
	@Column(name="registrationDate")
	private String registrationDate;
	
	@ManyToMany(fetch=FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH
			})
	@JoinTable(
			name = "vehicle_tyre",
			joinColumns =@JoinColumn(name="vehicle_id"),
			inverseJoinColumns=@JoinColumn(name="tyre_id")
			)
	private List<Tyre> tyres;
	
	
	public Vehicle() {
		
	}
	
	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getTax() {
		return tax;
	}

	public void setTax(double d) {
		this.tax = d;
	}

	public double getAnualTax() {
		return anualTax;
	}

	public void setAnualTax(double d) {
		this.anualTax = d;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Tyre> getTyres() {
		return tyres;
	}

	public void setTyres(List<Tyre> tyres) {
		this.tyres = tyres;
	}
	
	// add a convenience method
	
	public void addTyre(Tyre theTyre) {
		if(tyres == null) {
			tyres = new ArrayList<>();
		}
		
		tyres.add(theTyre);
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", plate=" + plate
				+ ", identificationNumber=" + identificationNumber + ", cilindricCapacity=" + cilindricCapacity
				+ ", color=" + color + ", fuel=" + fuel + ", power=" + power + ", productionDate=" + productionDate
				+ ", polutionNumber=" + polutionNumber + ", tax=" + tax + ", anualTax=" + anualTax
				+ ", registrationDate=" + registrationDate + "]";
	}
		
}
