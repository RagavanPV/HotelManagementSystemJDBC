package com.ragavan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.FoodItem;
import com.ragavan.model.FoodSchedule;
import com.ragavan.model.FoodType;
import com.ragavan.util.ConnectionUtil;

public class FoodScheduleDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int save(final FoodSchedule schedule) {
		final String sql = "insert into food_schedule(type_id,item_id,qty) values(?,?,?)";
		final Object[] params = { schedule.getTypes().getId(), schedule.getItems().getId(), schedule.getQty() };
		return jdbcTemplate.update(sql, params);
	}

	public int update(final FoodSchedule schedule) {
		final String sql = "update food_schedule set type_id=?,item_id=?,qty=? where id=?";
		final Object[] params = { schedule.getTypes().getId(), schedule.getItems().getId(), schedule.getQty() };
		return jdbcTemplate.update(sql, params);

	}

	public int updateQty(final FoodSchedule schedule) {
		final String sql = "update food_schedule set qty=? where type_id=? and item_id=?";
		final Object[] params = { schedule.getQty(), schedule.getTypes().getId(), schedule.getItems().getId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(final int id) {
		final String sql = "delete from food_schedule where id=?";
		return jdbcTemplate.update(sql, id);

	}

	public int deleteByItem(final int id) {
		final String sql = "delete from food_schedule where item_id=?";
		return jdbcTemplate.update(sql, id);

	}

	public int deleteByType(final int id) {
		final String sql = "delete from food_schedule where type_id=?";
		return jdbcTemplate.update(sql, id);

	}

	// Selecting data from table using LIST collections since it returns more
	// than on record
	public List<FoodSchedule> list() {
		final String sql = "select type,items,qty from food_schedule join food_types on type_id=food_types.id join food_items on item_id=food_items.id";
		return jdbcTemplate.query(sql, (rs, rowNum) -> fetchData(rs));
	}

	public FoodSchedule listById(int id) {
		String sql = "select id,type_id,item_id,qty from food_schedule where id=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> fetchData(rs));
	}

	private FoodSchedule fetchData(ResultSet rs) throws SQLException {
		final FoodSchedule foodSchedule = new FoodSchedule();
		final FoodType type = new FoodType();
		final FoodItem item = new FoodItem();
		type.setType(rs.getString("type"));
		item.setItemName(rs.getString("items"));
		foodSchedule.setTypes(type);
		foodSchedule.setItems(item);
		foodSchedule.setQty(rs.getInt("qty"));
		return foodSchedule;
	}

}
