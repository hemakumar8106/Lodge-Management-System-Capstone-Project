package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Room;
import com.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	public List<Room> listRoomByRoomReferenceId(String roomReferenceId) {
		
		return roomRepository.findRoomByRoomReferenceId(roomReferenceId);
	}

	public List<Room> listRoomByLocation(String location) {
		// TODO Auto-generated method stub
		return roomRepository.findRoomBylocation(location);
	}
}
