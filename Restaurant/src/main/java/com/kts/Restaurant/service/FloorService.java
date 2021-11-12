package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.repository.FloorRepository;

@Service
public class FloorService {

	@Autowired
	FloorRepository floorRepo;
}
