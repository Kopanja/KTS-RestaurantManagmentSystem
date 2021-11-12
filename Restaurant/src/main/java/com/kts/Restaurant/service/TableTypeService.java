package com.kts.Restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.dto.TableTypeDTO;
import com.kts.Restaurant.model.TableType;
import com.kts.Restaurant.repository.TableTypeRepository;
import com.kts.Restaurant.util.mapper.TableTypeMapper;

@Service
public class TableTypeService {

	@Autowired
	TableTypeRepository tableTypeRepo;
	
	TableTypeMapper mapper = new TableTypeMapper();
	
	public List<TableType> findAll(){
		return tableTypeRepo.findAll();
	}
	
	public List<TableTypeDTO> findAllDTOs(){
		List<TableTypeDTO> tableTypes = new ArrayList<TableTypeDTO>();
		for(TableType t: tableTypeRepo.findAll()) {
			tableTypes.add(mapper.toDto(t));
		}
		return tableTypes;
	}
	
	public TableType findById(Long id) {
		return tableTypeRepo.findById(id).orElse(null);
	}
	
	
}
