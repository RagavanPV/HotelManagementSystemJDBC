package com.ragavan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.FoodType;
import com.ragavan.util.ConnectionUtil;

public class FoodTypeDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int save(final FoodType type) {
		final String sql = "insert into food_types(type,time_start,time_end) values(?,?,?)";
		final Object[] params = { type.getType(), type.getTimeStart(), type.getTimeEnd() };
		return jdbcTemplate.update(sql, params);

	}

	public int update(final FoodType type) {
		final String sql = "update food_types set type=?,time_start=?,time_end=? where id=?";
		final Object[] params = { type.getType(), type.getTimeStart(), type.getTimeEnd(), type.getId() };
		return jdbcTemplate.update(sql, params);
	}

	public int updateByType(final FoodType type) {
		final String sql = "update food_types set time_start=?,time_end=? where type=?";
		final Object[] params = { type.getTimeStart(), type.getTimeEnd(), type.getType() };
		return jdbcTemplate.update(sql, params);
	}

	public int delete(final String type) {
		final String sql = "delete from food_types where type=?";
		return jdbcTemplate.update(sql, type);

	}

	public List<FoodType> list() {
		final String sql = "select id,type,time_start,time_end from food_types";
		return jdbcTemplate.query(sql, (rs, rowNum) -> fetchData(rs));

	}

	public FoodType listByType(String type) {
		final String sql = "select id,type,time_start,time_end from food_types where type=?";
		Object[] params = { type };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> fetchData(rs));

	}

	public List<FoodType> listCurrentType() {
		final String sql = "select id,type,time_start,time_end from food_types where curtime() between time_start and time_end";
		return jdbcTemplate.query(sql, (rs, rowNum) -> fetchData(rs));

	}

	private FoodType fetchData(ResultSet rs) throws SQLException {
		final FoodType foodType = new FoodType();
		foodType.setId(rs.getInt("id"));
		foodType.setType(rs.getString("type"));
		foodType.setTimeStart(rs.getTime("time_start").toLocalTime());
		foodType.setTimeEnd(rs.getTime("time_end").toLocalTime());
		return foodType;
	}

}
