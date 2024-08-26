package com.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="room-microservice")
public interface CustomerFeignClient {

	@GetMapping("/rooms/location/{location}")
	List<?> listRoomsByLocation(@PathVariable("location") String location);
	
}
