package com.auto.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tyre")
public class Tyre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dimension")
	private String dimension;

	@ManyToMany(fetch=FetchType.LAZY, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH
			})
	@JoinTable(
			name = "vehicle_tyre",
			joinColumns=@JoinColumn(name="tyre_id"),
			inverseJoinColumns=@JoinColumn(name="vehicle_id")
			)
	private List<Vehicle> vehicles;
	
	public Tyre() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}	
	
	@Override
	public String toString() {
		return "Tyre [dimension=" + dimension + "]";
	}
}
