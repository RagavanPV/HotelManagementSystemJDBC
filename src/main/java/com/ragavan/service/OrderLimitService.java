package com.ragavan.service;

import java.util.List;

import com.ragavan.dao.OrderLimitDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.OrderLimit;
import com.ragavan.validator.OrderLimitValidator;

public class OrderLimitService {
	OrderLimitValidator limitValidator = new OrderLimitValidator();
	OrderLimitDAO limitDAO = new OrderLimitDAO();

	public int saveService(int limit) throws ServiceException {
		try {
			limitValidator.validateSave(limit);
			return limitDAO.save(limit);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(int limit) throws ServiceException {
		try {
			limitValidator.validateSave(limit);
			return limitDAO.save(limit);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			limitValidator.validateSave(id);
			return limitDAO.save(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<OrderLimit> listService() {
		return limitDAO.list();
	}
}
