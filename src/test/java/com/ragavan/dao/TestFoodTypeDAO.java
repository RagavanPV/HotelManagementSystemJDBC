package com.ragavan.dao;

import java.util.List;

import com.ragavan.model.FoodType;

public class TestFoodTypeDAO {
	public static void main(final String[] args) {
		// /*Insert*/
		// FoodTypesDAO typeDao = new FoodTypesDAO();
		// FoodTypes types = new FoodTypes();
		// types.setId(5);
		// types.setType("test");
		// String timeStart = "06:00:00";
		// String timeEnd = "07:00:00";
		// types.setTimeStart(LocalTime.parse(timeStart));
		// types.setTimeEnd(LocalTime.parse(timeEnd));
		// typeDao.save(types);

		/* Update */

		/* List */
		final FoodTypeDAO foodTypeDao = new FoodTypeDAO();
		final List<FoodType> list = foodTypeDao.list();
		for (final FoodType foodType : list) {
			System.out.println(foodType);

		}
	}
}
