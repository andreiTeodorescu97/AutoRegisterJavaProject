package com.auto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.auto.entity.Vehicle;

@Repository
@EnableJpaRepositories
@Transactional
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
}
