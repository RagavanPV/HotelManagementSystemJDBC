package com.ragavan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.FoodItem;
import com.ragavan.util.ConnectionUtil;

public class FoodItemDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/* Start Insert Methods */
	public int saveAll(final FoodItem item) {
		final String sql = "insert into food_items(id,items,price) values(?,?,?)";
		final Object[] params = { item.getId(), item.getItemName(), item.getItemPrice() };
		return jdbcTemplate.update(sql, params);
	}

	public int save(final FoodItem item) {
		final String sql = "insert into food_items(items,price) values(?,?)";
		final Object[] params = { item.getItemName(), item.getItemPrice() };
		return jdbcTemplate.update(sql, params);
	}

	/* End Insert Methods */
	/* Start Update Methods */
	public int update(final FoodItem item) {
		final String sql = "update food_items set items=?,price=? where id=?";
		final Object[] params = { item.getItemName(), item.getItemPrice(), item.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public int updateNameById(final FoodItem item) {
		final String sql = "update food_items set items=? where id=?";
		final Object[] params = { item.getItemName(), item.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public int updatePriceByName(final FoodItem item) {
		final String sql = "update food_items set price=? where items=?";
		final Object[] params = { item.getItemPrice(), item.getItemName(), };
		return jdbcTemplate.update(sql, params);
	}

	/* End Update Methods */
	/* Start Delete Methods */
	public int delete(final String name) {
		final String sql = "delete from food_items where items=?";
		return jdbcTemplate.update(sql, name);
	}

	/* End Delete Methods */
	/* Start Select Methods */
	public List<FoodItem> list() {
		final String sql = "select id,items,price from food_items";
		return jdbcTemplate.query(sql, (rs, rowNum) -> fetchData(rs));
	}

	public FoodItem listByName(String name) {
		final String sql = "select id,items,price from food_items where items=?";
		Object[] params = { name };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> fetchData(rs));
	}

	public List<FoodItem> listByPrice(int priceStart, int priceEnd) {
		final String sql = "select id,items,price from food_items where price between ? and ?";
		Object[] params = { priceStart, priceEnd };
		return jdbcTemplate.query(sql, params, (rs, rowNum) -> fetchData(rs));
	}

	private FoodItem fetchData(ResultSet rs) throws SQLException {
		final FoodItem foodItems = new FoodItem();
		foodItems.setId(rs.getInt("id"));
		foodItems.setItemName(rs.getString("items"));
		foodItems.setItemPrice(rs.getInt("price"));
		return foodItems;
	}
	/* End Select Methods */

	/* Function for checking Items */
	public boolean functionCheckItem(String name) {
		String sql = "select fn_check_item(?)";
		return jdbcTemplate.queryForObject(sql, new Object[] { name }, Boolean.class);
	}
	/* End Function */
}
