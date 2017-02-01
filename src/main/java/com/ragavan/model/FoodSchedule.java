package com.ragavan.model;

import lombok.Data;

@Data
public class FoodSchedule {
	private int id;
	private FoodType types;
	private FoodItem items;
	private int qty;
}
