package com.ragavan.service;

import com.ragavan.dao.BillDetailDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.BillDetail;
import com.ragavan.validator.BillDetailValidator;

public class BillDetailService {
	BillDetailDAO billDetailDAO = new BillDetailDAO();
	BillDetailValidator billDetailValidator = new BillDetailValidator();

	public int saveService(BillDetail bill) throws ServiceException {
		try {
			billDetailValidator.validateSave(bill);
			return billDetailDAO.save(bill);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);

		}
	}
}
