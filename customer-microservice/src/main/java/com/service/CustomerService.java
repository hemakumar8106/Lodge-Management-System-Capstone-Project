package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addNewCustomer(Customer cust) {
		Customer customer=customerRepository.save(cust);
		return customer;
	}

	public List<Customer> listcustomerByCustomerId(int customerId) {
		
		return customerRepository.findCustomerByCustomerId(customerId);
	}
}
