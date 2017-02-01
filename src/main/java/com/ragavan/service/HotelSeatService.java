package com.ragavan.service;

import com.ragavan.dao.HotelSeatDAO;
import com.ragavan.exception.ServiceException;
import com.ragavan.exception.ValidationException;
import com.ragavan.model.HotelSeat;
import com.ragavan.validator.HotelSeatValidator;

public class HotelSeatService {
	HotelSeatDAO seatDAO = new HotelSeatDAO();
	HotelSeatValidator seatValidator = new HotelSeatValidator();

	public int saveService(String seat) throws ServiceException {
		try {
			seatValidator.validateSave(seat);
			return seatDAO.save(seat);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int updateService(HotelSeat seat) throws ServiceException {
		try {
			seatValidator.validateUpdate(seat);
			return seatDAO.update(seat);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	public int deleteService(String seat) throws ServiceException {
		try {
			seatValidator.validateDelete(seat);
			return seatDAO.delete(seat);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
