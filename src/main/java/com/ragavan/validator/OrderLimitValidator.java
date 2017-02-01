package com.ragavan.validator;

import com.ragavan.model.OrderLimit;
import static com.ragavan.util.ValidationUtil.*;

import com.ragavan.exception.ValidationException;

public class OrderLimitValidator {
	private static final String INVALID_LIMIT = "Invalid Limit";
	OrderLimit limit = new OrderLimit();

	public void validateSave(int limit) throws ValidationException {
		isInvalidInteger(limit, INVALID_LIMIT);
	}

	public void validateUpdate(int limit) throws ValidationException {
		isInvalidInteger(limit, INVALID_LIMIT);
	}

	public void validateDelete(int id) throws ValidationException {
		isInvalidInteger(id, INVALID_LIMIT);
	}
}
