package com.ironjom.taller_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironjom.taller_api.dto.CustomerDTO;
import com.ironjom.taller_api.model.Customer;
import com.ironjom.taller_api.repository.CustomerRepository;
import com.ironjom.taller_api.service.interfaz.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<CustomerDTO> findAllCustomers() throws Exception {
		List<CustomerDTO> customerDtoLst = new ArrayList<CustomerDTO>();

		try {
			List<Customer> customerList = customerRepository.findAll();

			customerList.forEach(customer -> {
				CustomerDTO customerDto = new CustomerDTO();
				customerDto.setIdCustomer(customer.getIdCustomer().longValue());
				customerDto.setStrDocument(customer.getStrDocument());
				customerDto.setStrName(customer.getStrName());
				customerDto.setStrPhone(customer.getStrPhone());
				customerDto.setStrEmail(customer.getStrEmail());
				customerDto.setIntNumberOfVehicles(customer.getVehicles().size());
				customerDto.setIntNumberOfBookings(customer.getBookings().size());
				customerDtoLst.add(customerDto);
			});
		} catch (Exception e) {
			log.error("Error ejecutando servicio findAllVehicles() ", e);
			throw new Exception();
		}
		return customerDtoLst;
	}

	@Override
	public void saveCustomer(CustomerDTO customerDto) throws Exception {
		try {
			Customer customer = new Customer();
			customer.setStrDocument(customerDto.getStrDocument());
			customer.setStrEmail(customerDto.getStrEmail());
			customer.setStrName(customerDto.getStrName());
			customer.setStrPhone(customerDto.getStrPhone());
			customerRepository.save(customer);
		} catch (Exception e) {
			log.error("Error ejecutando servicio saveCustomer() ", e);
			throw new Exception();
		}
	}

	@Override
	public CustomerDTO findCustomerById(Long id) throws Exception {
		CustomerDTO customerDto = new CustomerDTO();

		try {
			Customer customer = customerRepository.findById(id).get();

			customerDto.setIdCustomer(customer.getIdCustomer().longValue());
			customerDto.setStrDocument(customer.getStrDocument());
			customerDto.setStrName(customer.getStrName());
			customerDto.setStrPhone(customer.getStrPhone());
			customerDto.setStrEmail(customer.getStrEmail());
			customerDto.setIntNumberOfVehicles(customer.getVehicles().size());
			customerDto.setIntNumberOfBookings(customer.getBookings().size());
		} catch (Exception e) {
			log.error("Error ejecutando servicio findAllVehicles() ", e);
			throw new Exception();
		}
		return customerDto;
	}

	@Override
	public List<Customer> findCustomerByInfo(String strName, String strDocument) throws Exception {
		try {
			return customerRepository.findCustomerByInfo(strName, strDocument);
		} catch (Exception e) {
			log.error("Error ejecutando servicio findCustomerByInfo() ", e);
			throw new Exception();
		}
	}

}
