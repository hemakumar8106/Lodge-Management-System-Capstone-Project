package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

	List<Booking> findBookingsByBookingId(int bookingId);

}
