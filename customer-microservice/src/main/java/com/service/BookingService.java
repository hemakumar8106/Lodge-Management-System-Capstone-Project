package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Booking;
import com.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	private static Logger logger = LoggerFactory.getLogger(BookingService.class);

	public Booking addNewBooking(Booking book) {
		Booking booking=bookingRepository.save(book);
		logger.info("Booking is done and confirmed");
		return booking;
	}
	
	public List<Booking> listbookingByBookingId(int bookingId) {
		
		return bookingRepository.findBookingsByBookingId(bookingId);
	}

}
