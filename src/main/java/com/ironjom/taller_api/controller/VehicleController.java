package com.ironjom.taller_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ironjom.taller_api.dto.VehicleDTO;
import com.ironjom.taller_api.model.Vehicle;
import com.ironjom.taller_api.service.interfaz.VehicleService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	private ResponseEntity<List<VehicleDTO>> getVehicles() {
		try {
			return ResponseEntity.ok(vehicleService.findAllVehicles());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(vehicleService.findVehicleById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	private ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody VehicleDTO vehicleDto) {
		try {
			vehicleService.saveVehicle(vehicleDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
