package com.ragavan.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class FunctionDAO {
	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public Boolean functionCheckItem(String name) {
		String sql = "select fn_check_item(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, Boolean.class);
	}

	public Boolean functionCheckFoodSession(String name) {
		String sql = "select fn_check_food_session(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, Boolean.class);
	}

	public Boolean functionCheckSeat(String seatName) {
		String sql = "select fn_check_seat(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { seatName }, Boolean.class);
	}

	public Boolean functionCheckSeatStatus(String seatName) {
		String sql = "select fn_check_seat_status(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { seatName }, Boolean.class);
	}

	public int functionGetBillAmount(int orderSno) {
		String sql = "select fn_get_bill_amount(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { orderSno }, Integer.class);
	}

	public int functionGetOrderNumber(int seatNo) {
		String sql = "select fn_get_order_number(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { seatNo }, Integer.class);
	}

	public int functionGetQty(String name) {
		String sql = "select fn_get_qty(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, Integer.class);
	}
}
