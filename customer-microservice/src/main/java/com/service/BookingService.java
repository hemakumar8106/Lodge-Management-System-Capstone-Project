package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Booking;
import com.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	public Booking addNewBooking(Booking book) {
		Booking booking=bookingRepository.save(book);
		return booking;
	}
	
	public List<Booking> listbookingByBookingId(int bookingId) {
		
		return bookingRepository.findBookingsByBookingId(bookingId);
	}

}
