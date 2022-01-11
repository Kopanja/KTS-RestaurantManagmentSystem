package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.FloorDTO;
import com.kts.Restaurant.model.Floor;
import com.kts.Restaurant.repository.FloorRepository;

@Service
public class FloorService {

	@Autowired
	FloorRepository floorRepo;
	
	
	public FloorDTO toDTO(Floor floor) {
		return new FloorDTO(floor.getName());
	}
	
	
	public List<FloorDTO> getAll(){
		List<FloorDTO> floors = new ArrayList<FloorDTO>();
		for(Floor f : floorRepo.findAll()) {
			floors.add(this.toDTO(f));
		}
		
		return floors;
	}


	public void save(Floor floor) {
		floorRepo.save(floor);
		
	}
}
