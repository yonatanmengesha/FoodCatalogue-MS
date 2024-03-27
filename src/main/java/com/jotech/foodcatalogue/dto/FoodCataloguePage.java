package com.jotech.foodcatalogue.dto;

import java.util.List;

import com.jotech.foodcatalogue.entity.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodCataloguePage {
	
	private List<FoodItem> foodItemsList;
	private Restaurant restaurant;

}
