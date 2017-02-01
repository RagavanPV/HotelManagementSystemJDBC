package com.ragavan.util;

public class TestConnectionUtil {
	public static void main(String[] args) {

		// Step 1: Test getDatasource

		System.out.println(ConnectionUtil.dataSource());

		// Step 2: Test JdbcTemplate

		System.out.println(ConnectionUtil.getJdbcTemplate());
	}
}
