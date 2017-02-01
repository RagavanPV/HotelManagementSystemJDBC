package com.ragavan.dao;

import java.util.List;

import com.ragavan.model.FoodSchedule;

public class TestFoodScheduleDAO {
	public static void main(final String[] args) {
		final FoodScheduleDAO scheduleDao = new FoodScheduleDAO();
		final List<FoodSchedule> list = scheduleDao.list();
		for (final FoodSchedule foodSchedule : list) {
			System.out.println(foodSchedule.getItems().getItemName() + " " + foodSchedule.getTypes().getType() + " "
					+ foodSchedule.getQty());
		}

		// FoodScheduleDAO foodScheduleDao=new FoodScheduleDAO();
		// FoodSchedule schedule =new FoodSchedule();
		// FoodTypes types=new FoodTypes();
		// FoodItems items=new FoodItems();
		// types.setId(1);
		// items.setId(10);
		// schedule.setItems(items);
		// schedule.setTypes(types);
		// schedule.setQty(1000);
		// foodScheduleDao.save(schedule);

	}
}
