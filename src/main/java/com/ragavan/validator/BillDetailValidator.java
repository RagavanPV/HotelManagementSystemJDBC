package com.ragavan.validator;

import static com.ragavan.util.ValidationUtil.isInvalidInteger;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.BillDetail;

public class BillDetailValidator {
	public void validateSave(BillDetail billDetail) throws ValidationException {
		isInvalidInteger(billDetail.getOrderId(), "Invalid Order Id");
		isInvalidInteger(billDetail.getSeatId().getId(), "Invalid Seat Number");
	}
}
