package com.ragavan.validator;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodItem;

public class TestFoodItemValidator {
	public static void main(String[] args) throws ValidationException {
		FoodItem item = new FoodItem();
		FoodItemValidator itemValidator = new FoodItemValidator();
		item.setId(10);
		item.setItemName("Vaada");
		item.setItemPrice(10);
		itemValidator.validateSaveAll(item);

	}
}
