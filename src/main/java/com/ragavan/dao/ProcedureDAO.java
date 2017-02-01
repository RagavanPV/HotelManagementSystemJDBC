package com.ragavan.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class ProcedureDAO {
	private static final String ERR_MSG = "errMsg";
	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public String placeOrder(String seatName, String itemName, int qty) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_PLACE_ORDER").declareParameters(
				new SqlParameter("seatNo", Types.VARCHAR), new SqlParameter("item", Types.VARCHAR),
				new SqlParameter("qty", Types.INTEGER), new SqlOutParameter(ERR_MSG, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("seatNo", seatName).addValue("item", itemName)
				.addValue("qty", qty);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get(ERR_MSG);

	}

	public String payBills(int orderSno) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_PAY_BILLS").declareParameters(
				new SqlParameter("orderSno", Types.INTEGER), new SqlOutParameter(ERR_MSG, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("orderSno", orderSno);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get(ERR_MSG);

	}

	public String cancelOrder(String seatName, String itemName, int qty) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_PLACE_ORDER").declareParameters(
				new SqlParameter("seatname", Types.VARCHAR), new SqlParameter("item", Types.VARCHAR),
				new SqlParameter("qty", Types.INTEGER), new SqlOutParameter(ERR_MSG, Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("seatname", seatName).addValue("item", itemName)
				.addValue("qty", qty);
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get(ERR_MSG);

	}
}
