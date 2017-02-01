package com.ragavan.dao;

import com.ragavan.model.BillDetail;
import com.ragavan.model.HotelSeat;

public class TestBillDetailsDAO {
	public static void main(final String[] args) {
		// final BillDetailDAO billDao = new BillDetailDAO();
		// final List<BillDetail> list = billDao.list();
		// for (final BillDetail billDetails : list) {
		// System.out.println(billDetails);
		// }

		BillDetailDAO billDao = new BillDetailDAO();
		BillDetail bill = new BillDetail();
		bill.setOrderId(10);
		HotelSeat seat = new HotelSeat();
		seat.setId(10);
		bill.setSeatId(seat);
		billDao.save(bill);

	}
}
