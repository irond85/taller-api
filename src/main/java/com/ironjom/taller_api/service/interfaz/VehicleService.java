package com.ironjom.taller_api.service.interfaz;

import java.util.List;

import com.ironjom.taller_api.dto.VehicleDTO;
import com.ironjom.taller_api.model.Vehicle;

public interface VehicleService {
	List<VehicleDTO> findAllVehicles() throws Exception;

	List<VehicleDTO> findAllVehiclesByCustomer(Long idCustomer) throws Exception;

	VehicleDTO findVehicleById(Long idVehicle) throws Exception;

	void saveVehicle(VehicleDTO vehicleDto) throws Exception;
	
	List<Vehicle> findAllVehiclesByPlaca(String strPlaca) throws Exception;
}
