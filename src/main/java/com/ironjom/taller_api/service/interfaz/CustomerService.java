package com.ironjom.taller_api.service.interfaz;

import java.util.List;

import com.ironjom.taller_api.dto.CustomerDTO;
import com.ironjom.taller_api.model.Customer;

public interface CustomerService {
	List<CustomerDTO> findAllCustomers() throws Exception;

	CustomerDTO findCustomerById(Long id) throws Exception;

	void saveCustomer(Customer customer) throws Exception;
}
