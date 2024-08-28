package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.exception.CustomException;
import com.service.CustomerFeignClientService;
import com.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
    CustomerService customerService;
	
	@Autowired
    CustomerFeignClientService customerFeignClientService;
	
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@PostMapping("/")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer registration){
		logger.info("Registering New Customer With Required Details");
		Customer customer=customerService.registerNewCustomer(registration);
		logger.info("Customer is successfully registered");
		return new ResponseEntity<>(customer, HttpStatus.OK);	
	}
	
	@PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@Valid @RequestBody Map<String, String> loginData) {
		logger.info("Verifing the Customer login");
        String email = loginData.get("email");
        String password = loginData.get("password");
        Optional<Customer> customerLogin = customerService.loginCustomer(email, password);
        if (customerLogin.isPresent()) {
        	return ResponseEntity.ok("Login successful! you can now check rooms details.");
        }
        logger.error("Unable to login incorrect email or password");
        throw new CustomException("Invalid email or password");
    }
	
	@GetMapping("/rooms/location/{location}")
    public ResponseEntity<List<?>> viewRoomByLocation(@PathVariable("location") String location) {
		logger.info("Connecting to room microservice using feignclient");
		List<?> roomList = customerFeignClientService.listRoomByLocation(location);
		return new ResponseEntity<>(roomList, HttpStatus.OK);
		
    }

}
