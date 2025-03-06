package com.ironjom.taller_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ironjom.taller_api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
