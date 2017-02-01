package com.ragavan.validator;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodType;
import com.ragavan.util.ValidationUtil;

public class FoodTypeValidator {
	private static final String INVALID_END_TIME = "Invalid End Time";
	private static final String INVALID_START_TIME = "Invalid Start Time";
	private static final String INVALID_TYPE = "Invalid Type";

	public void validateSave(FoodType type) throws ValidationException {
		ValidationUtil.isInvalidString(type.getType(), INVALID_TYPE);
		ValidationUtil.isInvalidTime(type.getTimeStart(), INVALID_START_TIME);
		ValidationUtil.isInvalidTime(type.getTimeEnd(), INVALID_END_TIME);
	}

	public void validateUpdate(FoodType type) throws ValidationException {
		ValidationUtil.isInvalidString(type.getType(), INVALID_TYPE);
		ValidationUtil.isInvalidTime(type.getTimeStart(), INVALID_START_TIME);
		ValidationUtil.isInvalidTime(type.getTimeEnd(), INVALID_END_TIME);
		ValidationUtil.isInvalidInteger(type.getId(), "Invalid Id");
	}

	public void validateUpdateByType(FoodType type) throws ValidationException {
		ValidationUtil.isInvalidString(type.getType(), INVALID_TYPE);
		ValidationUtil.isInvalidTime(type.getTimeStart(), INVALID_START_TIME);
		ValidationUtil.isInvalidTime(type.getTimeEnd(), INVALID_END_TIME);
	}

	public void validateDelete(String type) throws ValidationException {
		ValidationUtil.isInvalidString(type, INVALID_TYPE);
	}

	public void validateListByType(String type) throws ValidationException {
		ValidationUtil.isInvalidString(type, INVALID_TYPE);
	}
}
