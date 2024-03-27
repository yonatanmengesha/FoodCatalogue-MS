package com.jotech.foodcatalogue.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jotech.foodcatalogue.dto.FoodCataloguePage;
import com.jotech.foodcatalogue.dto.FoodItemDTO;
import com.jotech.foodcatalogue.dto.Restaurant;
import com.jotech.foodcatalogue.entity.FoodItem;
import com.jotech.foodcatalogue.mapper.FoodItemMapper;
import com.jotech.foodcatalogue.repo.FoodItemRepo;

@Service
public class FoodCatalogueService {
	
	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	RestTemplate restTemplate;

	public FoodItemDTO addFoodItemDTO(FoodItemDTO foodItemDTO) {
		
		
		FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDTO));
		
		
		return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
		
		
	}

	public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {

		
		List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
		
		Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
		createFoodCataloguePage(foodItemList,restaurant);
		return null;
	}

	private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
		
		FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
		foodCataloguePage.setFoodItemsList(foodItemList);
		foodCataloguePage.setRestaurant(restaurant);
		
		return foodCataloguePage;
		
	}

	private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
		    
	return 	restTemplate.getForObject("http://RESTAURANT-SERVICE/fetchById/"+restaurantId, Restaurant.class);
	}

	private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
		
		return foodItemRepo.findByRestaurantId(restaurantId);
	}

}
