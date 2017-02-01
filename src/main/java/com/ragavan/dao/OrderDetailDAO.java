package com.ragavan.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ragavan.model.BillDetail;
import com.ragavan.model.FoodItem;
import com.ragavan.model.OrderDetail;
import com.ragavan.util.ConnectionUtil;

public class OrderDetailDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public int save(final OrderDetail order) {
		final String sql = "insert into order_details(bill_no,item_id,qty_no,orderDate) values(?,?,?,?)";
		final Object[] params = { order.getBillNo(), order.getItemId(), order.getQty(), order.getOrderDate() };
		return jdbcTemplate.update(sql, params);
	}

	public List<OrderDetail> list() {
		final String sql = "select order_details.id,bill_no,items,qty_no ,order_date,status from order_details join food_items on item_id=food_items.id";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final OrderDetail orderDetails = new OrderDetail();
			orderDetails.setId(rs.getInt("id"));
			final BillDetail bill = new BillDetail();
			bill.setId(rs.getInt("bill_no"));
			orderDetails.setBillNo(bill);
			final FoodItem item = new FoodItem();
			item.setItemName(rs.getString("items"));
			orderDetails.setItemId(item);
			orderDetails.setQty(rs.getInt("qty_no"));
			orderDetails.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
			orderDetails.setStatus(rs.getString("status"));
			return orderDetails;

		});
	}
}
