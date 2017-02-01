package com.ragavan.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDetail {
	private int id;
	private BillDetail billNo;
	private FoodItem itemId;
	private int qty;
	private LocalDateTime orderDate;
	private String status;
}
