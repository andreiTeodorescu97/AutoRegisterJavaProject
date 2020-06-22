package com.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.auto.dao.VehicleRepository;
import com.auto.entity.Vehicle;

@Service
public class VechileJspServiceImpl implements VehicleJspService {
	
	//@Autowired
	//private VehicleRepository vehicleRepo;
	
	/*public Page<Vehicle> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo -1,  pageSize);
		return this.vehicleRepo.findAll(pageable);
		
	}*/
	
}
