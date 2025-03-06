package com.ironjom.taller_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironjom.taller_api.dto.VehicleDTO;
import com.ironjom.taller_api.model.Customer;
import com.ironjom.taller_api.model.Vehicle;
import com.ironjom.taller_api.repository.CustomerRepository;
import com.ironjom.taller_api.repository.VehicleRepository;
import com.ironjom.taller_api.service.interfaz.VehicleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<VehicleDTO> findAllVehicles() throws Exception {
		List<Vehicle> vehiclesList = vehicleRepository.findAll();
		List<VehicleDTO> vehiclesDtoLst = new ArrayList<VehicleDTO>();

		try {
			vehiclesList.forEach(vehicle -> {
				VehicleDTO vehicleDTO = new VehicleDTO();
				vehicleDTO.setIdCustomer(vehicle.getCustomer().getIdCustomer().longValue());
				vehicleDTO.setIdVehicle(vehicle.getIdVehicle().longValue());
				vehicleDTO.setStrBrand(vehicle.getStrBrand());
				vehicleDTO.setStrModel(vehicle.getStrModel());
				vehicleDTO.setStrYear(vehicle.getStrYear());
				vehicleDTO.setDtmSOAT(vehicle.getDtmSOAT());
				vehicleDTO.setDtmTecno(vehicle.getDtmTecno());
				vehiclesDtoLst.add(vehicleDTO);
			});
		} catch (Exception e) {
			log.error("Error ejecutando servicio findAllVehicles() ", e);
			throw new Exception();
		}
		return vehiclesDtoLst;
	}

	@Override
	public List<VehicleDTO> findAllVehiclesByCustomer(Long idCustomer) throws Exception {
		List<Vehicle> vehiclesList = vehicleRepository.findVehiclesByCustomer(idCustomer);
		List<VehicleDTO> vehiclesDtoLst = new ArrayList<VehicleDTO>();

		try {
			vehiclesList.forEach(vehicle -> {
				VehicleDTO vehicleDTO = new VehicleDTO();
				vehicleDTO.setIdCustomer(vehicle.getCustomer().getIdCustomer().longValue());
				vehicleDTO.setIdVehicle(vehicle.getIdVehicle().longValue());
				vehicleDTO.setStrBrand(vehicle.getStrBrand());
				vehicleDTO.setStrModel(vehicle.getStrModel());
				vehicleDTO.setStrYear(vehicle.getStrYear());
				vehicleDTO.setDtmSOAT(vehicle.getDtmSOAT());
				vehicleDTO.setDtmTecno(vehicle.getDtmTecno());
				vehiclesDtoLst.add(vehicleDTO);
			});
		} catch (Exception e) {
			log.error("Error ejecutando servicio findAllVehiclesByCustomer() ", e);
			throw new Exception();
		}
		return vehiclesDtoLst;
	}

	@Override
	public VehicleDTO findVehicleById(Long idVehicle) throws Exception {
		VehicleDTO vehicleDTO = new VehicleDTO();
		try {
			Vehicle vehicle = vehicleRepository.findById(idVehicle).get();
			vehicleDTO.setIdCustomer(vehicle.getCustomer().getIdCustomer().longValue());
			vehicleDTO.setIdVehicle(vehicle.getIdVehicle().longValue());
			vehicleDTO.setStrBrand(vehicle.getStrBrand());
			vehicleDTO.setStrModel(vehicle.getStrModel());
			vehicleDTO.setStrYear(vehicle.getStrYear());
			vehicleDTO.setDtmSOAT(vehicle.getDtmSOAT());
			vehicleDTO.setDtmTecno(vehicle.getDtmTecno());
		} catch (Exception e) {
			log.error("Error ejecutando servicio findVehicleById() ",e);
			throw new Exception();
		}
		return vehicleDTO;
	}

	@Override
	public void saveVehicle(VehicleDTO vehicleDto) throws Exception {
		try {
			Customer vehicleCustomer = customerRepository.findById(vehicleDto.getIdCustomer()).get();
			if (vehicleCustomer != null) {
				Vehicle vehicleToSave = new Vehicle();
				vehicleToSave.setStrBrand(vehicleDto.getStrBrand());
				vehicleToSave.setStrModel(vehicleDto.getStrModel());
				vehicleToSave.setStrYear(vehicleDto.getStrYear());
				vehicleToSave.setDtmSOAT(vehicleDto.getDtmSOAT());
				vehicleToSave.setDtmTecno(vehicleDto.getDtmTecno());
				vehicleToSave.setCustomer(vehicleCustomer);

				vehicleRepository.save(vehicleToSave);
			}
		} catch (Exception e) {
			log.error("Error ejecutando servicio saveVehicle() ", e);
			throw new Exception();
		}
	}

}
