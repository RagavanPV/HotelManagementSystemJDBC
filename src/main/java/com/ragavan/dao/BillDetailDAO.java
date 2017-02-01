package com.ragavan.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.BillDetail;
import com.ragavan.model.HotelSeat;
import com.ragavan.util.ConnectionUtil;

public class BillDetailDAO {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	/**
	 * This method accepts Order
	 * 
	 * @param bill
	 */
	public int save(final BillDetail bill) {
		final String sql = "Insert into bill_details(order_no,seat_id) values (?,?)";
		final Object[] params = { bill.getOrderId(), bill.getSeatId().getId() };
		return jdbcTemplate.update(sql, params);
	}

	/**
	 * This method displays order
	 * 
	 * @return list
	 */
	public List<BillDetail> list() {
		final String sql = "select id,order_no,seat_id,order_date,bill_status,total_price from bill_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final BillDetail bill = new BillDetail();
			bill.setId(rs.getInt("id"));
			bill.setOrderId(rs.getInt("order_no"));

			final HotelSeat seatId = new HotelSeat();
			seatId.setId(rs.getInt("seat_id"));
			bill.setSeatId(seatId);
			final Timestamp timestamp = rs.getTimestamp("order_date");
			if (timestamp != null) {
				bill.setOrderDate(timestamp.toLocalDateTime());
			}
			bill.setBillStatus(rs.getInt("bill_status"));
			bill.setTotalPrice(rs.getInt("total_price"));
			return bill;

		});
	}

}
