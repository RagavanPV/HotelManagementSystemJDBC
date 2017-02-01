package com.ragavan.service;

import com.ragavan.exception.ServiceException;
import com.ragavan.model.FoodItem;

public class TestFoodItemService {
	public static void main(String[] args) throws ServiceException {
		FoodItem item = new FoodItem();
		FoodItemService itemService = new FoodItemService();
		item.setId(100);
		item.setItemName("IceCream");
		item.setItemPrice(1000);
		System.out.println(itemService.saveService(item));

	}
}
