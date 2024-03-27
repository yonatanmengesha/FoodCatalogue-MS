package com.jotech.foodcatalogue.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
	
	private int id;
	private String itemName;
	private String itemDescription;
	private boolean isVeg;
	private Long price;
	private Integer restaurantId;
	private Integer quantity;

}
