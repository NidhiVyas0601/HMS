package com.example.demo.roomDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.roomDetails.RoomDetails;
import com.example.demo.roomDetails.RoomDetailRepository;

@Service
public class RoomDetailService {
	@Autowired
	RoomDetailRepository roomDetailRepository;
	
	
	public List<RoomDetails> getAllRoomDetails() {
		return (List<RoomDetails>) roomDetailRepository.findAll();
	}
	
	public Optional<RoomDetails> getRoomDetail(int id) {
		return roomDetailRepository.findById(id);		
	}

	public void addRoomdetails(RoomDetails roomDetails) {
		roomDetailRepository.save(roomDetails);
		
	}
	
	public RoomDetails updateRoomDetails(RoomDetails roomDetails, int id) {

		return roomDetailRepository.save(roomDetails);
	}


	public void deleteRoomDetails(int id) {
		roomDetailRepository.deleteById(id);
				
	}

	
	

}
