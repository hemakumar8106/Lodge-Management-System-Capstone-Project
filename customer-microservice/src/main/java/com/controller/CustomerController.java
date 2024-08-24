package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
    CustomerService customerService;		
	
	@PostMapping("/")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer cust){
		Customer customer=customerService.addNewCustomer(cust);
		return new ResponseEntity<>(customer, HttpStatus.OK);	
	}
	
	@GetMapping("/{customerId}")
	public List<Customer> viewcustomerByCustomerId(@PathVariable("customerId")int customerId){
		List<Customer> customerList = customerService.listcustomerByCustomerId(customerId);
		return customerList;
	}	

}
