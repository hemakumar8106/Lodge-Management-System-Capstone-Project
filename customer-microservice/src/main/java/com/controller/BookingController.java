package com.controller;

import java.util.List;

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

import com.entity.Booking;
import com.exception.CustomException;
import com.service.BookingService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/customers")
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book")
    public ResponseEntity<Booking> saveBooking(@Valid @RequestBody Booking book) {
        try {
            Booking booking = bookingService.addNewBooking(book);
            return new ResponseEntity<>(booking, HttpStatus.CREATED); // Use CREATED status code for successful POST requests
        } catch (Exception e) {
            throw new CustomException("Error saving booking: " + e.getMessage());
        }
    }
	
	 @GetMapping("/bookings/{bookingId}")
	    public ResponseEntity<List<Booking>> viewBookingsByBookingId(@PathVariable("bookingId") int bookingId) {
	        try {
	            List<Booking> bookingList = bookingService.listbookingByBookingId(bookingId);
	            if (bookingList == null || bookingList.isEmpty()) {
	                throw new CustomException("No bookings found for Booking ID: " + bookingId);
	            }
	            return new ResponseEntity<>(bookingList, HttpStatus.OK);
	        } catch (Exception e) {
	            throw new CustomException(" " + e.getMessage());
	        }
	    }	
	
}
