package com.ragavan.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.HotelSeat;
import com.ragavan.util.ConnectionUtil;

public class HotelSeatDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int save(final String seat) {
		final String sql = "insert into hotel_seat(seat_no) values(?)";
		final Object[] params = { seat };
		return jdbcTemplate.update(sql, params);
	}

	public int update(final HotelSeat seat) {
		final String sql = "update hotel_seat set seat_no=?,status=? where id=?";
		final Object[] params = { seat.getSeatNo(), seat.getStatus(), seat.getId() };
		return jdbcTemplate.update(sql, params);

	}

	public int delete(final String seat) {
		final String sql = "delete from hotel_seat where seat_no=?";
		return jdbcTemplate.update(sql, seat);

	}

	public List<HotelSeat> list() {
		final String sql = "select id,seat_no,status from hotel_seat";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final HotelSeat hotelSeat = new HotelSeat();
			hotelSeat.setId(rs.getInt("id"));
			hotelSeat.setSeatNo(rs.getString("seat_no"));
			hotelSeat.setStatus(rs.getInt("status"));
			return hotelSeat;

		});
	}

}
