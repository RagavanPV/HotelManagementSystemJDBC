package com.ragavan.validator;

import com.ragavan.exception.ValidationException;
import com.ragavan.model.OrderDetail;
import static com.ragavan.util.ValidationUtil.*;

public class OrderDetailValidator {
	public void validateSave(OrderDetail order) throws ValidationException {
		isInvalidInteger(order.getBillNo().getId(), "Invalid BillNo");
		isInvalidInteger(order.getItemId().getId(), "Invalid ItemNo");
		isInvalidInteger(order.getQty(), "Invalid Qty");
		isInvalidDateTime(order.getOrderDate(), "Invalid Date");

	}
}
