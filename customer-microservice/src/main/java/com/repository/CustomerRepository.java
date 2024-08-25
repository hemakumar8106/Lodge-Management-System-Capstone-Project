package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	List<Customer> findCustomerByCustomerId(int customerId);
	
	Optional<Customer> findByEmail(String email);

	List<String> findRoomByCity(String city);
	
}
