package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {

	public List<Room> findRoomByRoomReferenceId(String roomReferenceId);
		
	public List<Room> findRoomBylocation(String location);

	
}
