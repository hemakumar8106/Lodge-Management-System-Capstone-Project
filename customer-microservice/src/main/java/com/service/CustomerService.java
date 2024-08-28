package com.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.exception.EmailAlreadyExistsException;
import com.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	public Customer registerNewCustomer(Customer cust) {
		 if (customerRepository.findByEmail(cust.getEmail()).isPresent()) {
			 logger.error("Email Already exits try with different mail Id");
	            throw new EmailAlreadyExistsException("Email already exists: " + cust.getEmail());
	        }
	        logger.info("Your Email id is considered and registering");
	        return customerRepository.save(cust);	    
	}

	public Optional<Customer> loginCustomer(String email, String password) {
		Optional<Customer> customerLogin=customerRepository.findByEmail(email);
		if (customerLogin.isPresent() && password.equals(customerLogin.get().getPassword())) {
			logger.info("Customer has successfuly logged in");
			return customerLogin;
		}
		return Optional.empty();
	}
	
}
