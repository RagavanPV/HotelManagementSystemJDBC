package com.ragavan.validator;

import static com.ragavan.util.ValidationUtil.*;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.HotelSeat;

public class HotelSeatValidator {
	private static final String INVALID_SEAT = "Invalid Seat";

	public void validateSave(String seat) throws ValidationException {
		isInvalidString(seat, INVALID_SEAT);
	}

	public void validateUpdate(HotelSeat seat) throws ValidationException {
		isInvalidString(seat.getSeatNo(), INVALID_SEAT);
		isInvalidInteger(seat.getStatus(), INVALID_SEAT);
	}

	public void validateDelete(String seat) throws ValidationException {
		isInvalidString(seat, INVALID_SEAT);
	}
}
