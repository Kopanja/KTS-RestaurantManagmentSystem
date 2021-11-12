package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.TableTypeDTO;
import com.kts.Restaurant.model.TableType;
import com.kts.Restaurant.util.DTOMapperInterface;

public class TableTypeMapper  implements DTOMapperInterface<TableType, TableTypeDTO> {

	@Override
	public TableType toEntity(TableTypeDTO dto) {
		return new TableType(null, dto.getNumOfSeats(), dto.getIcon(), dto.getName());
	}

	@Override
	public TableTypeDTO toDto(TableType entity) {
		return new TableTypeDTO(entity.getId(),entity.getNumOfSeats(), entity.getIcon(), entity.getName());
	}

}
