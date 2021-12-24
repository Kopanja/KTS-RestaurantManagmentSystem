package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Item;
import com.kts.Restaurant.model.Order;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.model.TableType;
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
	TableTypeRepository tableTypeRepo;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	WebSocketService webSocketService;
	
	TableMapper mapper = new TableMapper();
	
	public Table findByName(String name) {
		return tableRepo.findByName(name);
	}
	
	public void saveTableList(List<TableDTO> tables) {
		for(TableDTO dto : tables) {
			
			Table table = mapper.toEntity(dto);
			table.setId(null);
			TableType type = tableTypeRepo.findById(dto.getTypeId()).orElse(null);
			
			
			if(type != null) {
				table.setType(type);
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
				tableDTOs.add(new TableDTO(t.getId(), t.getType().getId(),t.getX(), t.getY(), t.getType().getNumOfSeats(), t.getType().getIcon(), orderService.toDto(t.getOrder()), t.getName()));

			}else {
				tableDTOs.add(new TableDTO(t.getId(), t.getType().getId(),t.getX(), t.getY(), t.getType().getNumOfSeats(), t.getType().getIcon(), t.getName()));

			}
			
		}
		return tableDTOs;
	}
	
	public TableDTO placeNewOrderForTable(String tableName, List<Item> items) {
		Table table = tableRepo.findByName(tableName);
		Order order = orderService.createOrderFromItemList(items);
		table.setOrder(order);
		table = tableRepo.save(table);
		webSocketService.sendDrinkOrder(order.getId());
		return this.toDto(table);
	}
	
	public TableDTO updateOrderForTable(String tableName, List<Item> newItems) {
		Table table = tableRepo.findByName(tableName);
		Order order = orderService.findById(table.getOrder().getId());
		order = orderService.addItemsToExistingOrder(order, newItems);
		table.setOrder(order);
		return this.toDto(table);
	}
	
	public TableDTO toDto(Table table) {
		return new TableDTO(table.getId(), table.getType().getId(), table.getX(), table.getY(),table.getType().getNumOfSeats(), table.getType().getIcon(), orderService.toDto(table.getOrder()), table.getName());
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
	
	public void resetDB() {
		tableRepo.deleteEveryNodeAndRel();
		tableRepo.createDBData();
	}

	

}
