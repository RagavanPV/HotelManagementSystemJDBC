package com.ragavan.service;

import java.util.List;

import com.ragavan.dao.FoodScheduleDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.FoodSchedule;
import com.ragavan.validator.FoodScheduleValidator;

public class FoodScheduleService {
	FoodScheduleValidator scheduleValidator = new FoodScheduleValidator();
	FoodScheduleDAO scheduleDAO = new FoodScheduleDAO();

	public int saveService(FoodSchedule schedule) throws ServiceException {
		try {
			scheduleValidator.validateSave(schedule);
			return scheduleDAO.save(schedule);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(FoodSchedule schedule) throws ServiceException {
		try {
			scheduleValidator.validateUpdate(schedule);
			return scheduleDAO.update(schedule);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateQtyService(FoodSchedule schedule) throws ServiceException {
		try {
			scheduleValidator.validateUpdateQty(schedule);
			return scheduleDAO.updateQty(schedule);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(int id) throws ServiceException {
		try {
			scheduleValidator.validateDelete(id);
			return scheduleDAO.delete(id);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public List<FoodSchedule> listService() {
		return scheduleDAO.list();
	}
}
