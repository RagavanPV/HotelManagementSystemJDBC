package com.ragavan.validator;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodItem;
import static com.ragavan.util.ValidationUtil.*;

public class FoodItemValidator {
	private static final String INVALID_ID = "Invalid Id";
	private static final String INVALID_PRICE = "Invalid Price";
	private static final String INVALID_NAME = "Invalid Name";

	public void validateSave(FoodItem item) throws ValidationException {
		isInvalidString(item.getItemName(), INVALID_NAME);
		isInvalidInteger(item.getItemPrice(), INVALID_PRICE);
	}

	public void validateSaveAll(FoodItem item) throws ValidationException {
		isInvalidString(item.getItemName(), INVALID_NAME);
		isInvalidInteger(item.getItemPrice(), INVALID_PRICE);
		isInvalidInteger(item.getId(), INVALID_ID);
	}

	public void validateUpdate(FoodItem item) throws ValidationException {
		isInvalidString(item.getItemName(), INVALID_NAME);
		isInvalidInteger(item.getItemPrice(), INVALID_PRICE);
		isInvalidInteger(item.getId(), INVALID_ID);
	}

	public void validateUpdateNameById(FoodItem item) throws ValidationException {
		isInvalidString(item.getItemName(), INVALID_NAME);
		isInvalidInteger(item.getId(), INVALID_ID);
	}

	public void validateUpdatePriceByName(FoodItem item) throws ValidationException {
		isInvalidString(item.getItemName(), INVALID_NAME);
		isInvalidInteger(item.getItemPrice(), INVALID_PRICE);
	}

	public void validateDelete(String item) throws ValidationException {
		isInvalidString(item, INVALID_NAME);
	}

	public void validateListByName(String name) throws ValidationException {
		isInvalidString(name, INVALID_NAME);
	}

	public void validateListByPrice(int start, int end) throws ValidationException {
		isInvalidInteger(start, "Invalid Start price");
		isInvalidInteger(end, "Invalid End price");
	}
}
