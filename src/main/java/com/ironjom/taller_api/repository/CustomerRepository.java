package com.ironjom.taller_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ironjom.taller_api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT * FROM customers WHERE str_name = :strName AND str_document =:strDocument", nativeQuery = true)
	List<Customer> findCustomerByInfo(String strName, String strDocument);
	
}
