package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Room;
import com.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	private static Logger logger = LoggerFactory.getLogger(RoomService.class);
	
	public List<Room> listRoomByRoomReferenceId(String roomReferenceId) {
		logger.info("Getting room details with room reference id "+roomReferenceId);
		return roomRepository.findRoomByRoomReferenceId(roomReferenceId);
	}

	public List<Room> listRoomByLocation(String location) {
		logger.info("Looking for rooms at location "+location);
		return roomRepository.findRoomBylocation(location);
	}
}
