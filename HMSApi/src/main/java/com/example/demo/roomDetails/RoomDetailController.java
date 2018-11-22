package com.example.demo.roomDetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.roomDetails.RoomDetails;
import com.example.demo.employee.Employee;
import com.example.demo.roomDetails.RoomDetailService;

@RestController
public class RoomDetailController {
	
	@Autowired
	RoomDetailService roomDetailService;
	

	
	@RequestMapping(value="/roomDetails", method=RequestMethod.GET)
	public List<RoomDetails> getAllroomdetails() {
		return roomDetailService.getAllRoomDetails();
	}
	
	@RequestMapping("/roomDetails/{id}")
	public Optional<RoomDetails> getRoomdetail(@PathVariable int id) {
		return roomDetailService.getRoomDetail(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/roomDetails")
	public void addRoomdetails(@RequestBody RoomDetails roomDetails) {
		roomDetailService.addRoomdetails(roomDetails);
	}
	
	
	@RequestMapping(method=RequestMethod.PATCH, value="/roomDetails/{id}")
	public ResponseEntity<RoomDetails> updateRoomdetails(@RequestBody RoomDetails roomDetails, @PathVariable int id) {
		Optional<RoomDetails> emp = roomDetailService.getRoomDetail(id);
		roomDetails.setId(id);
		roomDetailService.updateRoomDetails(roomDetails, id);
		if(emp == null){
            return new ResponseEntity<RoomDetails>(HttpStatus.NOT_FOUND);
        }
		
		RoomDetails roomDetails1 = roomDetailService.updateRoomDetails(roomDetails, id);
		 return new ResponseEntity<RoomDetails>(roomDetails1, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/roomDetails/{id}")
	public void deleteRoomdetails( @PathVariable int id) {
		roomDetailService.deleteRoomDetails(id);
	}

}
