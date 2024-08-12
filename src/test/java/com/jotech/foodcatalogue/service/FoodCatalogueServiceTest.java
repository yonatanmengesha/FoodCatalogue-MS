package com.jotech.foodcatalogue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.jotech.foodcatalogue.dto.FoodItemDTO;
import com.jotech.foodcatalogue.entity.FoodItem;
import com.jotech.foodcatalogue.mapper.FoodItemMapper;
import com.jotech.foodcatalogue.repo.FoodItemRepo;

public class FoodCatalogueServiceTest {
	
	@InjectMocks
	private FoodCatalogueService foodCatalogueService;
	
	@Mock
	private FoodItemRepo foodItemRepo;
	
	@Mock
	private RestTemplate restTemplate;
	
	@BeforeEach
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	public void testAddFoodItemDTO() {
		
		//Arrange
		FoodItemDTO foodItemDTO = new FoodItemDTO();
		FoodItem foodItem = new FoodItem();
		
		when(foodItemRepo.save(any(FoodItem.class))).thenReturn(foodItem);
		
		//Act
		//FoodItemDTO result = foodCatalogueService.addFoodItemDTO(foodItemDTO);
		
		//Assert
	//	verify(foodItemRepo,times(1)).save(any(FoodItem.class));
		
	//	assertEquals(FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItem),result);
		
	}

}
