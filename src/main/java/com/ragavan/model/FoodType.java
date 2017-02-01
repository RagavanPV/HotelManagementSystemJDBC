package com.ragavan.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class FoodType {
	private int id;
	private String type;
	private LocalTime timeStart;
	private LocalTime timeEnd;
}
