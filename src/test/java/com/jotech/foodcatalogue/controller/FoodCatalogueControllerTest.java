package com.jotech.foodcatalogue.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jotech.foodcatalogue.dto.FoodCataloguePage;
import com.jotech.foodcatalogue.dto.FoodItemDTO;
import com.jotech.foodcatalogue.dto.Restaurant;
import com.jotech.foodcatalogue.entity.FoodItem;
import com.jotech.foodcatalogue.mapper.FoodItemMapper;
import com.jotech.foodcatalogue.service.FoodCatalogueService;

public class FoodCatalogueControllerTest {
	
	@InjectMocks
	FoodCatalogueController foodCatalogueController;
    
	@Mock
	FoodCatalogueService foodCatalogueService;
	
	@BeforeEach
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
			
	}
	
	@Test
	public void testAddFoodItem() {
		
		
		// create the a mocked food item dto to be added 
		FoodItemDTO mockFoodItemDTO = new FoodItemDTO(1,"injera","Ethiopian Bread",true,8L,1,1);
		
		//mock the service behavior  
		
		when(foodCatalogueService.addFoodItemDTO(mockFoodItemDTO)).thenReturn(mockFoodItemDTO);
		
		//call the controller method
		
		ResponseEntity<FoodItemDTO>  response = foodCatalogueController.addFoodItem(mockFoodItemDTO);
		
		//verify the response 
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
		assertEquals(mockFoodItemDTO,response.getBody());
		
		//Verify the service method was called 
		
		verify(foodCatalogueService,times(1)).addFoodItemDTO(mockFoodItemDTO);
		
		
	}
	
	@Test
	public void testFetchRestaurantDetailsWithFoodMenue() {
		
		//Arrange
		Integer mockRestaurantId =1;
		FoodCataloguePage  mockFoodCataloguePage = new FoodCataloguePage();
		when(foodCatalogueService.fetchFoodCataloguePageDetails(mockRestaurantId))
		.thenReturn(mockFoodCataloguePage);
		
		//Act
		
		ResponseEntity<FoodCataloguePage> response = foodCatalogueController.fetchRestaurantDetailsWithFoodMenue(mockRestaurantId);
		
		
		//Assert
		
		verify(foodCatalogueService,times(1)).fetchFoodCataloguePageDetails(mockRestaurantId);
		assertEquals(response.getStatusCode(),HttpStatus.OK);
		//assertEquals(response.getBody(),mockFoodCataloguePage);
		assert  response.getBody()==mockFoodCataloguePage;
		
		

		
		
		
	}
}
