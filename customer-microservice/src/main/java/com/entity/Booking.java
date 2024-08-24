package com.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "room_reference_id")
    private String roomReferenceId;

    @Column(name = "booking_date")
    @Temporal(TemporalType.DATE)
    private Date bookingDate;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getRoomReferenceId() {
		return roomReferenceId;
	}

	public void setRoomReferenceId(String roomReferenceId) {
		this.roomReferenceId = roomReferenceId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Booking(int bookingId, int customerId, String roomReferenceId, Date bookingDate) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.roomReferenceId = roomReferenceId;
		this.bookingDate = bookingDate;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", roomReferenceId='" + roomReferenceId + '\'' +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
