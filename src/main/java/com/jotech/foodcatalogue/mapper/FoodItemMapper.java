package com.jotech.foodcatalogue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jotech.foodcatalogue.dto.FoodItemDTO;
import com.jotech.foodcatalogue.entity.FoodItem;

@Mapper
public interface FoodItemMapper {
	
	FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
	
	FoodItem  mapFoodItemDtoToFoodItem(FoodItemDTO foodItemDTO);
	FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

}
