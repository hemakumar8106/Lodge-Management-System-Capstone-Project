package com.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_id")
	private Integer roomId;
	 
	@Column(name = "room_reference_id")
	@NotBlank(message = "Room reference ID is required")
    @Size(min = 1, max = 50, message = "Room reference ID must be between 1 and 50 characters")
	private String roomReferenceId;

	@Column(name = "city")
	@NotBlank(message = "City is required")
    @Size(min = 1, max = 50, message = "City must be between 1 and 50 characters")
	private String city;

    @Column(name = "location")
    @NotBlank(message = "Location is required")
    @Size(min = 1, max = 100, message = "Location must be between 1 and 100 characters")
	private String location;

	@Column(name = "room_type")
	@NotBlank(message = "Room type is required")
    @Size(min = 1, max = 30, message = "Room type must be between 1 and 30 characters")
	private String roomType;

	@Column(name = "price")
	@NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be zero or a positive value")
	private BigDecimal price;
	   
	@Column(name = "complimentary_facilities")
	@Size(max = 255, message = "Complimentary facilities description cannot exceed 255 characters")
	private String complimentaryFacilities;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomReferenceId() {
		return roomReferenceId;
	}

	public void setRoomReferenceId(String roomReferenceId) {
		this.roomReferenceId = roomReferenceId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getComplimentaryFacilities() {
		return complimentaryFacilities;
	}

	public void setComplimentaryFacilities(String complimentaryFacilities) {
		this.complimentaryFacilities = complimentaryFacilities;
	}

	public Room() {
		super();
			// TODO Auto-generated constructor stub
	}

	public Room(Integer roomId, String roomReferenceId, String city, String location, String roomType,
			BigDecimal price, String complimentaryFacilities) {
		super();
		this.roomId = roomId;
		this.roomReferenceId = roomReferenceId;
		this.city = city;
		this.location = location;
		this.roomType = roomType;
		this.price = price;
		this.complimentaryFacilities = complimentaryFacilities;
	}
		
	@Override
	public String toString() {
		return "Room{" +
		       "roomId=" + roomId +
		       ", roomReferenceId='" + roomReferenceId + '\'' +
		       ", city='" + city + '\'' +
		       ", location='" + location + '\'' +
		       ", roomType='" + roomType + '\'' +
		       ", price=" + price +
		       ", complimentaryFacilities='" + complimentaryFacilities + '\'' +
		       '}';
	}         
}
