package com.ragavan.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BillDetail {

	private int id;
	private int orderId;
	private HotelSeat seatId;
	private LocalDateTime orderDate;
	private int billStatus;
	private int totalPrice;

}
