package com.ragavan.service;

import java.util.List;

import com.ragavan.dao.FoodItemDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodItem;
import com.ragavan.validator.FoodItemValidator;

public class FoodItemService {
	private static final String ITEM_IS_NOT_FOUND = "Item is Not Found";
	FoodItemDAO itemDAO = new FoodItemDAO();
	FoodItemValidator itemValidator = new FoodItemValidator();

	public int saveService(FoodItem item) throws ServiceException {
		try {
			itemValidator.validateSave(item);
			boolean result = itemDAO.functionCheckItem(item.getItemName());
			if (result) {
				throw new ServiceException("Item Already Present");
			}
			return itemDAO.save(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int saveAllService(FoodItem item) throws ServiceException {
		try {
			itemValidator.validateSaveAll(item);
			boolean result = itemDAO.functionCheckItem(item.getItemName());
			if (result) {
				throw new ServiceException("Item Already Present");
			}
			return itemDAO.saveAll(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(FoodItem item) throws ServiceException {
		try {
			itemValidator.validateUpdate(item);
			boolean result = itemDAO.functionCheckItem(item.getItemName());
			if (!result) {
				throw new ServiceException(ITEM_IS_NOT_FOUND);
			}
			return itemDAO.update(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateNameByIdService(FoodItem item) throws ServiceException {
		try {
			itemValidator.validateUpdateNameById(item);
			boolean result = itemDAO.functionCheckItem(item.getItemName());
			if (!result) {
				throw new ServiceException(ITEM_IS_NOT_FOUND);
			}
			return itemDAO.updateNameById(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updatePriceByNameService(FoodItem item) throws ServiceException {
		try {
			itemValidator.validateUpdatePriceByName(item);
			boolean result = itemDAO.functionCheckItem(item.getItemName());
			if (!result) {
				throw new ServiceException(ITEM_IS_NOT_FOUND);
			}
			return itemDAO.updatePriceByName(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(String item) throws ServiceException {
		try {
			itemValidator.validateDelete(item);
			boolean result = itemDAO.functionCheckItem(item);
			if (!result) {
				throw new ServiceException(ITEM_IS_NOT_FOUND);
			}
			return itemDAO.delete(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<FoodItem> listService() {
		return itemDAO.list();
	}

	public void listByNameService(String item) throws ServiceException {
		try {
			itemValidator.validateListByName(item);
			boolean result = itemDAO.functionCheckItem(item);
			if (!result) {
				throw new ServiceException(ITEM_IS_NOT_FOUND);
			}
			itemDAO.listByName(item);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public void listByPriceService(int start, int end) throws ServiceException {
		try {
			itemValidator.validateListByPrice(start, end);
			itemDAO.listByPrice(start, end);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
