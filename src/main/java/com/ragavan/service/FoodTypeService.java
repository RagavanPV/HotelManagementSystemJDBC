package com.ragavan.service;

import com.ragavan.dao.FoodTypeDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodType;
import com.ragavan.validator.FoodTypeValidator;

public class FoodTypeService {
	FoodTypeValidator typeValidator = new FoodTypeValidator();
	FoodTypeDAO typeDao = new FoodTypeDAO();

	public int saveService(FoodType type) throws ServiceException {
		try {
			typeValidator.validateSave(type);
			return typeDao.save(type);

		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(FoodType type) throws ServiceException {
		try {
			typeValidator.validateUpdate(type);
			return typeDao.update(type);

		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateByTypeService(FoodType type) throws ServiceException {
		try {
			typeValidator.validateUpdateByType(type);
			return typeDao.updateByType(type);

		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(String type) throws ServiceException {
		try {
			typeValidator.validateDelete(type);
			return typeDao.delete(type);

		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void listService() {
		FoodTypeDAO typeDAO = new FoodTypeDAO();
		typeDAO.list();
	}

	public void listCurrentTypeService() {
		FoodTypeDAO typeDAO = new FoodTypeDAO();
		typeDAO.listCurrentType();
	}

	public void listByTypeService(String type) throws ServiceException {
		try {
			typeValidator.validateListByType(type);
			typeDao.listByType(type);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
