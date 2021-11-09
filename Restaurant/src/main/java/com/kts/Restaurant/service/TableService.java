package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Restaurant;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.model.TableType;
import com.kts.Restaurant.repository.RestaurantRepository;
import com.kts.Restaurant.repository.TableRepository;
import com.kts.Restaurant.repository.TableTypeRepository;
import com.kts.Restaurant.util.mapper.TableMapper;

@Service
public class TableService {
	
	@Autowired
	TableRepository tableRepo;
	
	@Autowired
	TableTypeService tableTypeService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	RestaurantRepository restaurantRepo;
	
	@Autowired
	TableTypeRepository tableTypeRepo;
	
	@Autowired
	OrderService orderService;
	
	TableMapper mapper = new TableMapper();
	
	public void saveTableList(List<TableDTO> tables) {
		for(TableDTO dto : tables) {
			
			Table table = mapper.toEntity(dto);
			table.setId(null);
			TableType type = tableTypeRepo.findById(dto.getTypeId()).orElse(null);
			Restaurant restaurant = restaurantRepo.findById(dto.getRestaurantId()).orElse(null);
			
			if(type != null) {
				table.setType(type);
			}
			if(restaurant != null) {
				table.setRestaurant(restaurant);
			}
			
			tableRepo.save(table);
		}
		
	}
	
	public List<TableDTO> getTableList(){
		List<Table> tables = tableRepo.findAll();
		List<TableDTO> tableDTOs = new ArrayList<TableDTO>();
		for(Table t : tables) {
			//Long tableId, Long typeId, Long restaurantId, int x, int y, int numOfSeats, String icon
			if(t.getOrder() != null && t.getOrder().getItems() != null) {
				tableDTOs.add(new TableDTO(t.getId(), t.getType().getId(),t.getRestaurant().getId(),t.getX(), t.getY(), t.getType().getNumOfSeats(), t.getType().getIcon(), orderService.toDto(t.getOrder())));

			}else {
				tableDTOs.add(new TableDTO(t.getId(), t.getType().getId(),t.getRestaurant().getId(),t.getX(), t.getY(), t.getType().getNumOfSeats(), t.getType().getIcon()));

			}
			
		}
		return tableDTOs;
	}
	
	public void deleteAll() {
		tableRepo.deleteAll();
	}
	
	public Table findById(Long id) {
		return tableRepo.findById(id).orElse(null);
	}
	
	public Table save(Table table) {
		return tableRepo.save(table);
	}

}
