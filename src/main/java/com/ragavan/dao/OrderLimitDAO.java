package com.ragavan.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.OrderLimit;
import com.ragavan.util.ConnectionUtil;

public class OrderLimitDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int save(final int limit) {
		final String sql = "Insert into order_limit(max_no) values(?)";
		return jdbcTemplate.update(sql, limit);
	}

	public int update(final int limit) {
		final String sql = "update order_limit set max_no=?";
		return jdbcTemplate.update(sql, limit);

	}

	public int delete(final int id) {
		final String sql = "delete from order_details where id=?";
		return jdbcTemplate.update(sql, id);

	}

	public List<OrderLimit> list() {
		final String sql = "select id,max_no from order_limit";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final OrderLimit limit = new OrderLimit();
			limit.setId(rs.getInt("id"));
			limit.setMaxNo(rs.getInt("max_no"));
			return limit;

		});
	}
}
