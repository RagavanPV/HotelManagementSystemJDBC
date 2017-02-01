package com.ragavan.validator;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodSchedule;
import com.ragavan.util.ValidationUtil;

public class FoodScheduleValidator {
	private static final String INVALID_QUANTITY = "Invalid Quantity";
	private static final String INVALID_ITEM_ID = "Invalid item_id";
	private static final String INVALID_TYPE_ID = "Invalid type_id";

	public void validateSave(FoodSchedule schedule) throws ValidationException {
		ValidationUtil.isInvalidInteger(schedule.getTypes().getId(), INVALID_TYPE_ID);
		ValidationUtil.isInvalidInteger(schedule.getItems().getId(), INVALID_ITEM_ID);
		ValidationUtil.isInvalidInteger(schedule.getQty(), INVALID_QUANTITY);
	}

	public void validateUpdate(FoodSchedule schedule) throws ValidationException {
		ValidationUtil.isInvalidInteger(schedule.getTypes().getId(), INVALID_TYPE_ID);
		ValidationUtil.isInvalidInteger(schedule.getItems().getId(), INVALID_ITEM_ID);
		ValidationUtil.isInvalidInteger(schedule.getQty(), INVALID_QUANTITY);
		ValidationUtil.isInvalidInteger(schedule.getId(), "Invalid Id");
	}

	public void validateUpdateQty(FoodSchedule schedule) throws ValidationException {
		ValidationUtil.isInvalidInteger(schedule.getTypes().getId(), INVALID_TYPE_ID);
		ValidationUtil.isInvalidInteger(schedule.getItems().getId(), INVALID_ITEM_ID);
		ValidationUtil.isInvalidInteger(schedule.getQty(), INVALID_QUANTITY);
	}

	public void validateDelete(int id) throws ValidationException {
		ValidationUtil.isInvalidInteger(id, "Invalid id");
	}

	public void validateListById(int id) throws ValidationException {
		ValidationUtil.isInvalidInteger(id, "Invalid id");
	}
}
