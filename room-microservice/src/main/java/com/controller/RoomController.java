package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Room;
import com.exception.CustomException;
import com.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
    RoomService roomService;
	
	
	@GetMapping("/{roomReferenceId}")
    public ResponseEntity<List<Room>> viewRoomByRoomReferenceId(@PathVariable("roomReferenceId") String roomReferenceId) {
        try {
            List<Room> roomList = roomService.listRoomByRoomReferenceId(roomReferenceId);
            if (roomList == null || roomList.isEmpty()) {
                throw new CustomException("No rooms found with room reference ID: " + roomReferenceId);
            }
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException(" " + e.getMessage());
        }
    }
	
	@GetMapping("/location/{location}")
    public ResponseEntity<List<Room>> viewRoomByLocation(@PathVariable("location") String location) {
        try {
            List<Room> roomList = roomService.listRoomByLocation(location);
            if (roomList == null || roomList.isEmpty()) {
                throw new CustomException("No rooms found at location: " + location);
            }
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException(" " + e.getMessage());
        }
    }
}
