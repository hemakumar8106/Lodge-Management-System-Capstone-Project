package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Room;
import com.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
    RoomService roomService;
	
	@GetMapping("/{roomReferenceId}")
	public List<Room> viewroomByRoomReferenceId(@PathVariable("roomReferenceId")String roomReferenceId){
		List<Room> roomList = roomService.listRoomByRoomReferenceId(roomReferenceId);
		return roomList;
	}
	
	@GetMapping("/location/{location}")
	public List<Room> viewroomByLocation(@PathVariable("location")String location){
		List<Room> roomList = roomService.listRoomByLocation(location);
		return roomList;
	}
}
