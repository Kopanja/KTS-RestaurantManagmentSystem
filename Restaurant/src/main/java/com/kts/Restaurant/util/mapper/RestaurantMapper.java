package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.RestaurantDTO;
import com.kts.Restaurant.model.Restaurant;
import com.kts.Restaurant.util.DTOMapperInterface;

public class RestaurantMapper implements DTOMapperInterface<Restaurant, RestaurantDTO> {

	@Override
	public Restaurant toEntity(RestaurantDTO dto) {
		Restaurant restaurant = new Restaurant(dto.getId(), dto.getName());
		return restaurant;
	}

	@Override
	public RestaurantDTO toDto(Restaurant entity) {
		RestaurantDTO dto = new RestaurantDTO(entity.getId(), entity.getName());
		return dto;
	}

}
