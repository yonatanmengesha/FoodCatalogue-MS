package com.jotech.foodcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotech.foodcatalogue.dto.FoodCataloguePage;
import com.jotech.foodcatalogue.dto.FoodItemDTO;
import com.jotech.foodcatalogue.service.FoodCatalogueService;

@RestController
@RequestMapping("/foodCatalogue")
@CrossOrigin
public class FoodCatalogueController {
	@Autowired
	FoodCatalogueService foodCatalogueService;
	
	
	@PostMapping("/addFoodItem")
	public ResponseEntity<FoodItemDTO>  addFoodItem(@RequestBody FoodItemDTO foodItemDTO){
		
		
		 FoodItemDTO savedFoodItem =  foodCatalogueService.addFoodItemDTO(foodItemDTO);
		 
		 return new ResponseEntity<>(savedFoodItem , HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
	public ResponseEntity<FoodCataloguePage>fetchRestaurantDetailsWithFoodMenue(@PathVariable Integer restaurantId){
		
		FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
		
		return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
		
	}

}
