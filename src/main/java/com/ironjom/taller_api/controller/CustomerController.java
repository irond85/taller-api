package com.ironjom.taller_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ironjom.taller_api.dto.CustomerDTO;
import com.ironjom.taller_api.dto.VehicleDTO;
import com.ironjom.taller_api.model.Customer;
import com.ironjom.taller_api.service.interfaz.CustomerService;
import com.ironjom.taller_api.service.interfaz.VehicleService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController()
@RequestMapping("/api/v1/customers")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	private ResponseEntity<List<CustomerDTO>> getCustomers() {
		try {
			return ResponseEntity.ok(customerService.findAllCustomers());
		} catch (Exception e) {
			log.error("ERROR ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(customerService.findCustomerById(id));
		} catch (Exception e) {
			log.error("ERROR ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/{id}/vehicles")
	private ResponseEntity<List<VehicleDTO>> getVehicleByIdCustomer(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(vehicleService.findAllVehiclesByCustomer(id));
		} catch (Exception e) {
			log.error("ERROR ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	private ResponseEntity<Object> saveCustomer(@Valid @RequestBody CustomerDTO customer)
			throws MethodArgumentNotValidException {
		try {
			List<Customer> listCustomer = customerService.findCustomerByInfo(customer.getStrName(),
					customer.getStrDocument());
			if (listCustomer != null && !listCustomer.isEmpty()) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya existe");
			}

			customerService.saveCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			log.error("ERROR: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
