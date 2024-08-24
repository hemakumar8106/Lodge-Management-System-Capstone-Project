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

import com.entity.Booking;
import com.service.BookingService;

@RestController
@RequestMapping("/customers")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book")
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking book){
		Booking booking=bookingService.addNewBooking(book);
		return new ResponseEntity<>(booking, HttpStatus.OK);	
	}
	
	@GetMapping("/bookings/{bookingId}")
	public List<Booking> viewbookingsByBookingId(@PathVariable("bookingId")int bookingId){
		List<Booking> bookingList = bookingService.listbookingByBookingId(bookingId);
		return bookingList;
	}
	
	
}
