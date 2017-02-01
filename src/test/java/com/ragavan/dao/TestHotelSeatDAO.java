package com.ragavan.dao;

import java.util.List;

import com.ragavan.model.HotelSeat;

public class TestHotelSeatDAO {
	public static void main(final String[] args) {
		// HotelSeatDAO hotelDao=new HotelSeatDAO();
		// hotelDao.save("S11");

		final HotelSeatDAO hotelDao = new HotelSeatDAO();
		final List<HotelSeat> list = hotelDao.list();
		for (final HotelSeat hotelseat : list) {
			System.out.println(hotelseat);
		}

		// HotelSeatDAO hotelDao=new HotelSeatDAO();
		// hotelDao.delete("S11");
	}
}
