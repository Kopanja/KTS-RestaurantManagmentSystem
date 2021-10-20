package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.RestaurantDTO;
import com.kts.Restaurant.model.Restaurant;
import com.kts.Restaurant.repository.RestaurantRepository;
import com.kts.Restaurant.repository.TableRepository;
import com.kts.Restaurant.repository.TableTypeRepository;
import com.kts.Restaurant.util.mapper.RestaurantMapper;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepo;
	
	@Autowired
	TableTypeRepository tableTypeRepo;
	
	@Autowired
	TableRepository tableRepo;

	RestaurantMapper mapper = new RestaurantMapper();
	
	
	public List<RestaurantDTO> findAll() {
		
		List<RestaurantDTO> restaurantDTOs = new ArrayList<RestaurantDTO>();
		List<Restaurant> restaurants = restaurantRepo.findAll();
		
		if(!restaurants.isEmpty()) {
			for(Restaurant r : restaurants) {
				restaurantDTOs.add(mapper.toDto(r));
			}
		}
		if(!restaurantDTOs.isEmpty()) {
			return restaurantDTOs;
		}
		return null;
	}

	public RestaurantDTO findById(Long id) {
		RestaurantDTO restaurantDTO = null;
		Restaurant restaurant = restaurantRepo.findById(id).orElse(null);
		if(restaurant != null) {
			restaurantDTO = mapper.toDto(restaurant);
		}
		return restaurantDTO;
	}

}
