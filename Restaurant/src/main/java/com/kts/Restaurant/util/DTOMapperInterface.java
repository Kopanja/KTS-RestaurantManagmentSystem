package com.kts.Restaurant.util;

public interface DTOMapperInterface<Entity,Dto> {
	
	Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

}
