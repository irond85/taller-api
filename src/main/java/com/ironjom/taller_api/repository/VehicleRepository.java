package com.ironjom.taller_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ironjom.taller_api.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	@Query(value = "SELECT * FROM vehicles WHERE id_customer_v = :idCustomer", nativeQuery = true)
	List<Vehicle> findVehiclesByCustomer(Long idCustomer);
	
	@Query(value = "SELECT * FROM vehicles WHERE str_placa = :strPlaca", nativeQuery = true)
	List<Vehicle> findVehiclesByPlaca(String strPlaca);

}
