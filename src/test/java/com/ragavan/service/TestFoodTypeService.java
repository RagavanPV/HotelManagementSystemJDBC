package com.ragavan.service;

import java.time.LocalTime;

import com.ragavan.exception.ServiceException;
import com.ragavan.model.FoodType;

public class TestFoodTypeService {
	public static void main(String[] args) {
		FoodType type = new FoodType();
		FoodTypeService foodTypeService = new FoodTypeService();
		type.setId(5);
		type.setType("Brunch");
		type.setTimeStart(LocalTime.parse("01:00:00"));
		type.setTimeEnd(LocalTime.parse("03:00:00"));
		try {
			System.out.println(foodTypeService.saveService(type));
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
