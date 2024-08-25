package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer registerNewCustomer(Customer cust) {
		Customer customer=customerRepository.save(cust);
		return customer;
	}

	public List<Customer> listcustomerByCustomerId(int customerId) {
		
		return customerRepository.findCustomerByCustomerId(customerId);
	}

	public Optional<Customer> loginCustomer(String email, String password) {
		Optional<Customer> customerLogin=customerRepository.findByEmail(email);
		if (customerLogin.isPresent() && password.equals(customerLogin.get().getPassword())) {
			return customerLogin;
		}
		return Optional.empty();
	}

	public List<String> listRoomByCity(String city) {
		// TODO Auto-generated method stub
		return customerRepository.findRoomByCity(city);
	}
}
