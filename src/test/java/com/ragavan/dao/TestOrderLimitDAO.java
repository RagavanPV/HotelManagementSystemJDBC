package com.ragavan.dao;

import java.util.List;

import com.ragavan.model.OrderLimit;

public class TestOrderLimitDAO {
	public static void main(final String[] args) {
		// OrderLimitDAO limitDao = new OrderLimitDAO();
		// limitDao.save(10);

		final OrderLimitDAO OrderLimitDao = new OrderLimitDAO();
		final List<OrderLimit> list = OrderLimitDao.list();
		for (final OrderLimit orderLimit : list) {
			System.out.println(orderLimit);
		}
	}
}
