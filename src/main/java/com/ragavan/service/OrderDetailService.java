package com.ragavan.service;

import java.util.List;

import com.ragavan.dao.OrderDetailDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.OrderDetail;
import com.ragavan.validator.OrderDetailValidator;

public class OrderDetailService {
	OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	OrderDetailValidator orderDetailValidator = new OrderDetailValidator();

	public int saveService(OrderDetail order) throws ServiceException {
		try {
			orderDetailValidator.validateSave(order);
			return orderDetailDAO.save(order);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public List<OrderDetail> listService() {
		return orderDetailDAO.list();

	}
}
