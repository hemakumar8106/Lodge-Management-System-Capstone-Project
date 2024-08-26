package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	
	@Autowired
    CustomerFeignClient customerFeignClient;
	
	@PostMapping("/")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer registration){
		Customer customer=customerService.registerNewCustomer(registration);
		return new ResponseEntity<>(customer, HttpStatus.OK);	
	}
	
	@PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        Optional<Customer> customerLogin = customerService.loginCustomer(email, password);
        if (customerLogin.isPresent()) {
        	return ResponseEntity.ok("Login successful! you can now check rooms details.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
	
	@GetMapping("/rooms/location/{location}")
	public List<?> viewroomsByLocation(@PathVariable("location")String location){
		List<?> roomList = customerFeignClient.listRoomsByLocation(location);
		return roomList;
	}
	
	@GetMapping("/{customerId}")
	public List<Customer> viewcustomerByCustomerId(@PathVariable("customerId")int customerId){
		List<Customer> customerList = customerService.listcustomerByCustomerId(customerId);
		return customerList;
	}	

}
