package com.kts.Restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.Restaurant.model.TableType;
import com.kts.Restaurant.repository.TableTypeRepository;

@Service
public class TableTypeService {

	@Autowired
	TableTypeRepository tableTypeRepo;
	
	
	public TableType findById(Long id) {
		return tableTypeRepo.findById(id).orElse(null);
	}
	
	
}
