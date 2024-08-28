package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@GetMapping("/{roomReferenceId}")
    public ResponseEntity<List<Room>> viewRoomByRoomReferenceId(@PathVariable("roomReferenceId") String roomReferenceId) {
        try {       	
            List<Room> roomList = roomService.listRoomByRoomReferenceId(roomReferenceId);
            if (roomList == null || roomList.isEmpty()) {
            	logger.error("Invalid room reference id "+roomReferenceId);
                throw new CustomException("No rooms found with room reference ID: " + roomReferenceId);
            }
            logger.info("Room details are "+roomList);
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
            	logger.error("Rooms are not available at location "+location);
                throw new CustomException("No rooms found at location: " + location);
            }
            logger.info("Rooms are available at given location "+location);
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException(" " + e.getMessage());
        }
    }
}
